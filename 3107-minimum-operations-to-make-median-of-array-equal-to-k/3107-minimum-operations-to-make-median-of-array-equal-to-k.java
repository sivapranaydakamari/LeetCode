class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int median = nums.length / 2;
        int n = nums.length;
        long operations = 0;
        if(nums[median] == k) return 0;
        else if(nums[median] < k){
            int i = median;
            while(i < n && nums[i] <= k){
                operations += (k - nums[i]);
                i++;
            }
        }
        else{
            int i = median;
            while(i >= 0 && nums[i] >= k){
                operations += (nums[i] - k);
                i--;
            }
        }
        return operations; 
    }
}