class Solution {
    private long MOD = 1000000007;
    public int minimumCost(int[] nums, int k) {
        long op = 0, cost = 0, res = k;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > res){
                long need = nums[i] - res;
                long extra = (need + k - 1L) / k;
                op += extra;
                res += extra * k;
            }
            res -= nums[i];
        }
        long a = op, b = op + 1;
        if(a % 2 == 0) a /= 2;
        else b /= 2;
        return (int) (((a % MOD) * (b % MOD)) % MOD);
    }
}