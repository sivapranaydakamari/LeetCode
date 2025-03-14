class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> rangeArr = new ArrayList<>();
        String str;
        int l = 0, r = l+1;
        while(r < nums.length){
            if(nums[r]-1 != nums[r-1]){
                if(nums[l] == nums[r-1])
                    str = Integer.toString(nums[l]);
                else
                    str = Integer.toString(nums[l]) + "->" + Integer.toString(nums[r-1]);
                rangeArr.add(str);
                l = r;
            }
            r++;
        }

        if(nums[l] == nums[nums.length-1])
            str = Integer.toString(nums[l]);
        else
            str = Integer.toString(nums[l]) + "->" + Integer.toString(nums[nums.length-1]);
        
        rangeArr.add(str);
        return rangeArr;
    }
}