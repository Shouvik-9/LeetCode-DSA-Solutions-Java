class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        Boolean[][][] dp = new Boolean[n][n][n + 1];
        return solve(s1, s2, 0, 0, n, dp);
    }

    private boolean solve(String s1, String s2, int i, int j, int len, Boolean[][][] dp) {
        if (dp[i][j][len] != null) {
            return dp[i][j][len];
        }

        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return dp[i][j][len] = true;
        }

        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return dp[i][j][len] = false;
            }
        }

        for (int k = 1; k < len; k++) {
            if (solve(s1, s2, i, j, k, dp) &&
                solve(s1, s2, i + k, j + k, len - k, dp)) {
                return dp[i][j][len] = true;
            }

            if (solve(s1, s2, i, j + len - k, k, dp) &&
                solve(s1, s2, i + k, j, len - k, dp)) {
                return dp[i][j][len] = true;
            }
        }

        return dp[i][j][len] = false;
    }
}