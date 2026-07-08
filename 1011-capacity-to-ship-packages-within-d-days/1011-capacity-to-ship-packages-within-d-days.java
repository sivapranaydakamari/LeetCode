class Solution {
    private boolean isPossible(int capacity, int[] weights, int days){
        int d = 1, current = 0;
        for(int weight: weights){
            if((current + weight) > capacity){
                d++;
                current = 0;
            }
            current += weight;
        }
        return d <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxload = weights[0], minload = weights[0];
        for(int i = 1; i < weights.length; i++){
            maxload += weights[i];
            minload = Math.max(minload, weights[i]);
        }
        int low = minload, high = maxload;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, weights, days)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}