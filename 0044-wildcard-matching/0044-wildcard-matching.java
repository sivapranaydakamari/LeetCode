class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return solve(0, 0, s, p, n, m, dp);
    }
    private boolean solve(int i, int j, String s, String p, int n, int m, Boolean[][] dp){
        if(j == m) return i == n;
        if(dp[i][j] != null) return dp[i][j];
        if(j < m && p.charAt(j) == '*'){
            boolean skip = solve(i, j + 1, s, p, n, m, dp);
            boolean taken = i < n && solve(i + 1, j, s, p, n, m, dp);
            return dp[i][j] = taken || skip;
        }

        if(i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
            return dp[i][j] = solve(i + 1, j + 1, s, p, n, m, dp);
        }
        return dp[i][j] = false;
    }
}