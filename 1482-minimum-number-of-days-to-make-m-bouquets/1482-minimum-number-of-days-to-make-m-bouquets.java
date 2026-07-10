class Solution {
    private boolean isPossible(int[] bloomDay, int day, int m, int k){
        int count = 0, consec = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= day){
                consec++;
                if(consec == k){
                    count++;
                    consec = 0;
                }
            }else{
                consec = 0;
            }
        }
        return count >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;
        int maxDay = bloomDay[0], minDay = bloomDay[0];
        for(int i = 1; i < bloomDay.length; i++){
            maxDay = Math.max(maxDay, bloomDay[i]);
            minDay = Math.min(minDay, bloomDay[i]);
        }

        int low = minDay, high = maxDay;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(bloomDay, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}