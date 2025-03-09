class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 1) return false;
        int i = 0;
        while(i < nums.length){
            int j = Math.max(0, i-k);
            while(j < i){
                if(nums[i] == nums[j]){
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }
}