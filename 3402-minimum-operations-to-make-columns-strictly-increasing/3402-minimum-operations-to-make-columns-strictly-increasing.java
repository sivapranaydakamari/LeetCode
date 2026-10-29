class Solution {
    public int minimumOperations(int[][] grid) {
        int minOperations = 0;
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] <= grid[i - 1][j]){
                    int add = Math.abs((grid[i - 1][j] + 1) - grid[i][j]);
                    minOperations += add;
                    grid[i][j] += add;
                }
            }
        } 
        return minOperations;
    }
}