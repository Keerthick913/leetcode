// Last updated: 29/09/2026, 09:18:51
1class Solution {
2    public int reversePairs(int[] nums) {
3        return mergeSort(nums, 0, nums.length - 1);
4    }
5    private int countPairs(int[] nums, int left, int mid, int right){
6        int count = 0;
7        int temp = mid + 1;
8        for(int i = left; i <= mid; i++){
9            while(temp <= right && (long) nums[i] > (long) 2 * nums[temp]){
10                temp++;
11            }
12            count += (temp - (mid + 1));
13        }
14
15        return count;
16    }
17
18    private int mergeSort(int[] nums, int left, int right){
19        if(left >= right) {
20            return 0;
21        }
22        int mid = left + (right - left) / 2;
23        int count = 0;
24
25        count += mergeSort(nums, left, mid);
26        count += mergeSort(nums, mid + 1, right);
27        count += countPairs(nums, left, mid, right);
28        merge(nums, left, mid, right);
29
30        return count;
31    }
32
33    private void merge(int[] nums, int left, int mid, int right){
34        int[] temp = new int[right - left + 1];
35
36        int i = left;
37        int j = mid + 1;
38        int k = 0;
39
40        while(i <= mid && j <= right){
41            if(nums[i] <= nums[j]){
42                temp[k] = nums[i];
43                i++;
44            }
45            else {
46                temp[k] = nums[j];
47                j++;
48            }
49            k++;
50        }
51        while(i <= mid){
52            temp[k] = nums[i];
53            i++;
54            k++;
55        }
56        while(j <= right){
57            temp[k] = nums[j];
58            j++;
59            k++;
60        }
61
62        for(int x = 0; x < temp.length; x++){
63            nums[left + x] = temp[x];
64        }
65    }
66}
67