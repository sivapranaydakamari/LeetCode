class Solution {
    private boolean isPossible(int sum, int[] nums, int k){
        int count = 1;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(currentSum + nums[i] > sum){
                count++;
                currentSum = nums[i];
            }else{
                currentSum += nums[i];
            }
        }
        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int maxSum = nums[0], minSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxSum += nums[i];
            minSum = Math.max(minSum, nums[i]);
        }

        int low = minSum, high = maxSum;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, nums, k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}