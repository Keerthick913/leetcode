// Last updated: 27/08/2026, 09:14:23
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4        Map<Character, Character> mapping = new HashMap<>();
5        mapping.put(')', '(');
6        mapping.put('}', '{');
7        mapping.put(']', '[');
8
9        for (char c : s.toCharArray()) {
10            if (mapping.containsValue(c)) {
11                stack.push(c);
12            } else if (mapping.containsKey(c)) {
13                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
14                    return false;
15                }
16            }
17        }
18
19        return stack.isEmpty();        
20    }
21}