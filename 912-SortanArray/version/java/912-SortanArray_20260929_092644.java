// Last updated: 29/09/2026, 09:26:44
1class Solution {
2    public int[] sortArray(int[] nums) {
3        int n = nums.length;
4        for (int i = n / 2 - 1; i >= 0; i--) {
5            heapify(nums, n, i);
6        }
7        for (int i = n - 1; i > 0; i--) {
8            int temp = nums[0];
9            nums[0] = nums[i];
10            nums[i] = temp;
11            heapify(nums, i, 0);
12        }
13
14        return nums;
15    }
16
17    private void heapify(int[] nums, int n, int i) {
18        int largest = i;
19        int left = 2 * i + 1;
20        int right = 2 * i + 2;
21
22        if (left < n && nums[left] > nums[largest]) largest = left;
23        if (right < n && nums[right] > nums[largest]) largest = right;
24
25        if (largest != i) {
26            int swap = nums[i];
27            nums[i] = nums[largest];
28            nums[largest] = swap;
29
30            heapify(nums, n, largest);
31        }
32    }
33}
34