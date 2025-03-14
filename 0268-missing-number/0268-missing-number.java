class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n*(n+1))/2, numsSum = 0;
        for(int i= 0; i < n; i++){
            numsSum += nums[i];
        }
        return totalSum - numsSum;
    }
}