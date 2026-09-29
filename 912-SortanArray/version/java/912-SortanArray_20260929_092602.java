// Last updated: 29/09/2026, 09:26:02
1class Solution {
2    public int[] sortArray(int[] nums) {
3        int n = nums.length;
4
5        // Build max heap
6        for (int i = n / 2 - 1; i >= 0; i--) {
7            heapify(nums, n, i);
8        }
9
10        // Extract elements one by one from heap
11        for (int i = n - 1; i > 0; i--) {
12            int temp = nums[0];
13            nums[0] = nums[i];
14            nums[i] = temp;
15
16            heapify(nums, i, 0);
17        }
18
19        return nums;
20    }
21
22    private void heapify(int[] nums, int n, int i) {
23        int largest = i;
24        int left = 2 * i + 1;
25        int right = 2 * i + 2;
26
27        if (left < n && nums[left] > nums[largest]) largest = left;
28        if (right < n && nums[right] > nums[largest]) largest = right;
29
30        if (largest != i) {
31            int swap = nums[i];
32            nums[i] = nums[largest];
33            nums[largest] = swap;
34
35            heapify(nums, n, largest);
36        }
37    }
38}
39