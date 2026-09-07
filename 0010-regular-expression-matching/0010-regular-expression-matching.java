class Solution {
    private boolean expressionMatch(int i, int j, String s, String p, int n, int m, Boolean[][] dp){
        if(j == m) return i == n;
        if(dp[i][j] != null) return dp[i][j];
        boolean firstMatch = false;
        if(i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            firstMatch = true;
        }
        if(j + 1 < m && p.charAt(j + 1) == '*'){
            boolean skip = expressionMatch(i, j + 2, s, p, n, m, dp);
            boolean taken = false;
            if(firstMatch){
                taken = expressionMatch(i + 1, j, s, p, n, m, dp);
            }
            dp[i][j] = taken || skip;
            return dp[i][j];
        }
        if(firstMatch) {
            return dp[i][j] = expressionMatch(i + 1, j + 1, s, p, n, m, dp);
        }
        return dp[i][j] = false;

    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return expressionMatch(0, 0, s, p, n, m, dp);
    }
}