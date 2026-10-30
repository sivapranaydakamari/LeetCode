class Solution {
    public int minimumLevels(int[] possible) {
        int total = 0;
        int n = possible.length;
        for(int i = 0; i < n; i++){
            if(possible[i] == 0) total -= 1;
            else total += 1;
        }

        int currSum = 0;
        int levels = 0;
        for(int i = 0; i < n; i++){
            if(possible[i] == 0) currSum -= 1;
            else currSum += 1;
            if(currSum > total - currSum){
                levels = i + 1;
                break;
            }
        }
        if(levels < n && levels != 0) return levels;
        return -1;
    }
}