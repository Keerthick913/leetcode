// Last updated: 17/07/2026, 14:46:34
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int sIndex = 0, pIndex = 0, matchIndex = 0, starIndex = -1;
4        while (sIndex < s.length()) {
5            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
6                sIndex++;
7                pIndex++;
8            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
9                starIndex = pIndex;
10                matchIndex = sIndex;
11                pIndex++;
12            } else if (starIndex != -1) {
13                pIndex = starIndex + 1;
14                matchIndex++;
15                sIndex = matchIndex;
16            } else {
17                return false;
18            }
19        }
20        
21        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
22            pIndex++;
23        }
24        
25        return pIndex == p.length();
26    }
27}