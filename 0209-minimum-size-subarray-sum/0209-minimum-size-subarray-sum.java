class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        for(int end = 0; end < nums.length; end++){
            currSum += nums[end];
            while(currSum >= target){
                minLen = Math.min(minLen, end - start + 1);
                currSum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}