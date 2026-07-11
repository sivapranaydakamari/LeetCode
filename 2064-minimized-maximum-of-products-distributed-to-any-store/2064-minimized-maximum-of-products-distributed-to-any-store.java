class Solution {
    private boolean isPossible(int maxQuantity, int[] quantities, int n){
        int stores = 0;
        for(int i = 0; i < quantities.length; i++){
            stores += Math.ceil((double) quantities[i] / maxQuantity);
        }
        return stores <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = quantities[0];
        int ans = 0;
        for(int i = 1; i < quantities.length; i++){
            high = Math.max(high, quantities[i]);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, quantities, n)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}