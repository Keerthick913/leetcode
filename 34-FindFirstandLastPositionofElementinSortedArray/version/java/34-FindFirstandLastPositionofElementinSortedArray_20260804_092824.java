// Last updated: 04/08/2026, 09:28:24
1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3       return new int[]{
4        first(nums, target), last(nums, target)
5       };
6    }
7    private int first(int[] nums, int target) {
8        int left = 0, right = nums.length - 1, res = -1;
9        while (left <= right) {
10            int mid = left + (right - left) / 2;
11            if (nums[mid] >= target) {
12                if (nums[mid] == target)
13                    res = mid;
14                right = mid - 1;
15            } else {
16                left = mid + 1;
17            }
18        }
19        return res;
20    }
21
22    private int last(int[] nums, int target) {
23        int left = 0, right = nums.length - 1, res = -1;
24
25        while (left <= right) {
26            int mid = left + (right - left) / 2;
27
28            if (nums[mid] <= target) {
29                if (nums[mid] == target)
30                    res = mid;
31                left = mid + 1;
32            } else {
33                right = mid - 1;
34            }
35        }
36
37        return res;
38    }
39}