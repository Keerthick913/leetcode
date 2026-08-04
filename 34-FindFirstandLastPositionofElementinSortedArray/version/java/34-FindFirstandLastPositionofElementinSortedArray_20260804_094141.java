// Last updated: 04/08/2026, 09:41:41
1class Solution {
2    public List<List<String>> partition(String s) {
3        List<List<String>> result = new ArrayList<>();
4        backtrack(s, 0, new ArrayList<>(), result);
5        return result;
6    }
7    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
8        if (start == s.length()) {
9            result.add(new ArrayList<>(current));
10            return;
11        }
12        for (int end = start; end < s.length(); end++) {
13            if (isPalindrome(s, start, end)) {
14                current.add(s.substring(start, end + 1));
15                backtrack(s, end + 1, current, result);
16                current.remove(current.size() - 1);
17            }
18        }
19    }
20
21    private boolean isPalindrome(String s, int left, int right) {
22        while (left < right) {
23            if (s.charAt(left++) != s.charAt(right--)) {
24                return false;
25            }
26        }
27        return true;
28    }
29}