class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += nums[i];
        }
        if(total % 2 != 0){
            return false;
        }
        int target = total / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            for(int sum = 0; sum <= target; sum++){
                dp[i][sum] = dp[i - 1][sum];
                if(nums[i - 1] <= sum){
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - nums[i - 1]];
                }
            }
        }

        return dp[n][target];

    }
}