// Last updated: 17/07/2026, 14:42:39
1class Solution {
2    public int longestValidParentheses(String s) {
3        ArrayDeque<Integer> stack = new ArrayDeque<>();
4        stack.push(-1); int result = 0;
5        for(int i = 0; i < s.length(); i++) {
6            if(s.charAt(i) == '(') stack.push(i);
7            else {
8                stack.pop();
9                if(stack.isEmpty()) stack.push(i);
10                else result = Math.max(result, i - stack.peek());
11            }
12        }
13        return result;
14    }
15}