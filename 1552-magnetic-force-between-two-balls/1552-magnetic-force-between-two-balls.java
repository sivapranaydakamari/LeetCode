class Solution {
    private boolean isPossible(int dis, int[] position, int m){
        int balls = 1;
        int lastPlaced = position[0];
        for(int i = 1; i < position.length; i++){
            if(position[i] - lastPlaced >= dis){
                balls++;
                lastPlaced = position[i];
            }
        }
        return balls >= m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1, high = position[position.length - 1] - position[0];
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, position, m)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }
}