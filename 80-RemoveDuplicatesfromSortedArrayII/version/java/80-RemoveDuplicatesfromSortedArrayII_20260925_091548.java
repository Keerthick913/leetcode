// Last updated: 25/09/2026, 09:15:48
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int k = 2;
4
5        for (int i = 2; i < nums.length; i++) {
6            if (nums[i] != nums[k - 2]) {
7                nums[k] = nums[i];
8                k++;
9            }
10        }
11
12        return k;        
13    }
14}