class Solution {
    private boolean isPossible(int speed, int[] piles, int h){
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            hours += Math.ceil((double) piles[i]/speed);
        }
        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 1; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        int low = 1, high = max;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, piles, h)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}