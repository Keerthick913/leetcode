// Last updated: 24/09/2026, 08:59:07
1class Solution {
2    public List<Integer> findDuplicates(int[] nums) {
3        List<Integer> result = new ArrayList<>();
4        int n = nums.length;
5        for (int i = 0; i < n; i++) {
6            int num = Math.abs(nums[i]);
7            int idx = num - 1;
8            if (nums[idx] < 0)
9                result.add(num);
10            nums[idx] *= -1;
11        }
12        return result;
13    }
14}