class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(grid[i], '#');
        }
        grid[0][0] = '.';
        for(int i = 0; i < m; i++){
            grid[i][0] = '.';
        }
        for(int i = 0; i < n; i++){
            grid[m - 1][i] = '.';
        }
        String[] ans = new String[m];
        for(int i = 0; i < m; i++){
            ans[i] = new String(grid[i]);
        }
        return ans;
    }
}