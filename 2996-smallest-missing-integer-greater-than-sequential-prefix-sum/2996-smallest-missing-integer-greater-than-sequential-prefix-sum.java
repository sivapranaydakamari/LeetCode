class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] + 1) sum += nums[i];
            else break;
        }
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);

        int x = sum;
        while(set.contains(x)) x++;

        return x;
    }
}