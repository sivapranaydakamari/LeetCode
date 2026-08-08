class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k <= 0) return new int[0];
        if(k == 1) return nums;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(i % k == 0) prefix[i] = nums[i];
            else prefix[i] = Math.max(prefix[i - 1], nums[i]);
        }

        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if((i + 1) % k == 0) suffix[i] = nums[i];
            else suffix[i] = Math.max(suffix[i + 1], nums[i]);
        }
        int start = 0;
        int[] maxWindow = new int[n - k + 1];
        int i = 0;
        for(int end = k - 1; end < n; end++){
            maxWindow[i++] = Math.max(suffix[start], prefix[end]);
            start++;
        }
        return maxWindow;
    }
}