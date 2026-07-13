class Solution {
    private long MOD = 1000000007;
    private long INV2 = 500000004;
    public int minimumCost(int[] nums, int k) {
        long op = 0, cost = 0, res = k;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > res){
                long need = nums[i] - res;
                long extra = (need + k - 1L) / k;
                op += extra;
                long sum = ((op % MOD) * ((op + 1) % MOD)) % MOD;
                cost = (sum * INV2) % MOD;
                res += extra * k;
            }
            res -= nums[i];
        }
        return (int) (cost % MOD);
    }
}