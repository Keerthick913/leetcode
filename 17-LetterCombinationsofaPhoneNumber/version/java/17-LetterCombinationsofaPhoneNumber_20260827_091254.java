// Last updated: 27/08/2026, 09:12:54
1class Solution {
2    public List<String> letterCombinations(String digits) {
3        List<String> res = new ArrayList<>();
4        
5        if (digits == null || digits.length() == 0) {
6            return res;
7        }
8        
9        Map<Character, String> digitToLetters = new HashMap<>();
10        digitToLetters.put('2', "abc");
11        digitToLetters.put('3', "def");
12        digitToLetters.put('4', "ghi");
13        digitToLetters.put('5', "jkl");
14        digitToLetters.put('6', "mno");
15        digitToLetters.put('7', "pqrs");
16        digitToLetters.put('8', "tuv");
17        digitToLetters.put('9', "wxyz");
18        
19        backtrack(digits, 0, new StringBuilder(), res, digitToLetters);
20        
21        return res;        
22    }
23
24    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digitToLetters) {
25        if (idx == digits.length()) {
26            res.add(comb.toString());
27            return;
28        }
29        
30        String letters = digitToLetters.get(digits.charAt(idx));
31        for (char letter : letters.toCharArray()) {
32            comb.append(letter);
33            backtrack(digits, idx + 1, comb, res, digitToLetters);
34            comb.deleteCharAt(comb.length() - 1);
35        }
36    }    
37}