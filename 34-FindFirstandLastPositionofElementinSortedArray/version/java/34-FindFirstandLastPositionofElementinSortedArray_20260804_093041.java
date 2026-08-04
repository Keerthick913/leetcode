// Last updated: 04/08/2026, 09:30:41
1class Solution {
2    public List<List<Integer>> permuteUnique(int[] nums) {
3        List<List<Integer>> result = new ArrayList<>();
4        Arrays.sort(nums); 
5        boolean[] used = new boolean[nums.length];
6        backtrack(nums, new ArrayList<>(), used, result);
7        return result;
8    }
9    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
10        if (current.size() == nums.length) {
11            result.add(new ArrayList<>(current));
12            return;
13        }
14        for (int i = 0; i < nums.length; i++) {
15            if (used[i]) continue;
16            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
17
18            used[i] = true;
19            current.add(nums[i]);
20            backtrack(nums, current, used, result);
21            current.remove(current.size() - 1);
22            used[i] = false;
23        }
24    }
25}