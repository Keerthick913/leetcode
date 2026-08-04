// Last updated: 04/08/2026, 09:37:05
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int n = word1.length();
4        int m = word2.length();
5        int[][] dp = new int[n + 1][m + 1];
6        for (int i = 0; i <= n; i++) {
7            dp[i][0] = i;
8        }
9        for (int j = 0; j <= m; j++) {
10            dp[0][j] = j;
11        }
12        for (int i = 1; i <= n; i++) {
13            for (int j = 1; j <= m; j++) {
14                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
15                    dp[i][j] = dp[i - 1][j - 1];
16                } else {
17                    int insert = dp[i][j - 1] + 1;
18                    int delete = dp[i - 1][j] + 1;
19                    int replace = dp[i - 1][j - 1] + 1;
20                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
21                }
22            }
23        }
24        return dp[n][m];
25    }
26}