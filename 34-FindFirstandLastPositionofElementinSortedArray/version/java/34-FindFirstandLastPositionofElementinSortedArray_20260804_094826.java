// Last updated: 04/08/2026, 09:48:26
1class Solution {
2    public String shortestPalindrome(String s) {
3        if (s == null || s.length() <= 1) {
4            return s;
5        }
6        String rev = new StringBuilder(s).reverse().toString();
7        String temp = s + "#" + rev;
8        int[] lps = buildLPS(temp);
9        int longestPalindromePrefixLen = lps[lps.length - 1];
10        String suffixToPrefix = rev.substring(0, s.length() - longestPalindromePrefixLen);
11        return suffixToPrefix + s;
12    }
13    private int[] buildLPS(String s) {
14        int n = s.length();
15        int[] lps = new int[n];
16        int len = 0;
17        int i = 1;
18        while (i < n) {
19            if (s.charAt(i) == s.charAt(len)) {
20                len++;
21                lps[i] = len;
22                i++;
23            } else {
24                if (len != 0) {
25                    len = lps[len - 1];
26                } else {
27                    lps[i] = 0;
28                    i++;
29                }
30            }
31        }
32        return lps;
33    }
34}