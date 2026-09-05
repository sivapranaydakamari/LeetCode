class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxPrefix = new int[n];
        maxPrefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }

        int[] minSuffix = new int[n];
        minSuffix[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            minSuffix[i] = Math.min(minSuffix[i + 1], nums[i]);
        }

        for(int i = 0; i < n; i++){
            int score = maxPrefix[i] - minSuffix[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}