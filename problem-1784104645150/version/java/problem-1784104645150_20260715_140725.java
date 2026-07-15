// Last updated: 15/07/2026, 14:07:25
1class Solution {
2    public List<Integer> getRow(int rowIndex) {
3        List<Integer> res = new ArrayList<>();
4        res.add(1);
5        long prev = 1;
6        for (int k = 1; k <= rowIndex; k++){
7            long next_val = prev * (rowIndex - k + 1)/ k;
8            res.add((int) next_val);
9            prev = next_val;
10        }
11        return res;
12        
13    }
14}