class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int curr = 0;
        int winRate = 0;
        for(int i = 1; i < skills.length; i++){
            if(skills[curr] > skills[i]){
                winRate++;
                if(winRate >= k) return curr;
            }else{
                curr = i;
                winRate = 1;
                if(winRate >= k) return curr;
            }
        }
        return curr;
    }
}