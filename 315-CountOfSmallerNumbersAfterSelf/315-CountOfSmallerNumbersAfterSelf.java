// Last updated: 14/07/2026, 16:15:26
import java.util.*;

class Solution {
    int [] count;
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        mergeSort(pairs, 0, n - 1);
        
        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }
    
    private void mergeSort(int[][] pairs, int start, int end) {
        if (start >= end) return;
        
        int mid = start + (end - start) / 2;
        mergeSort(pairs, start, mid);
        mergeSort(pairs, mid + 1, end);
        
        merge(pairs, start, mid, end);
    }
    
    private void merge(int[][] pairs, int start, int mid, int end) {
        int[][] temp = new int[end - start + 1][2];
        int left = start;
        int right = mid + 1;
        int k = 0;
        int rightSmallerCount = 0;

        while (left <= mid && right <= end) {
            if (pairs[right][0] < pairs[left][0]) {
                rightSmallerCount++;
                temp[k++] = pairs[right++];
            } else {
                count[pairs[left][1]] += rightSmallerCount;
                temp[k++] = pairs[left++];
            }
        }

        while (left <= mid) {
            count[pairs[left][1]] += rightSmallerCount;
            temp[k++] = pairs[left++];
        }

        while (right <= end) {
            temp[k++] = pairs[right++];
        }

        System.arraycopy(temp, 0, pairs, start, temp.length);
    }
}