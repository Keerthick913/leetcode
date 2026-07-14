// Last updated: 14/07/2026, 16:18:01
import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m]; 
        int k = 0;
        
        for (int i = 0; i < n; i++) {
            merged[k++] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            merged[k++] = nums2[i];
        }
        
        Arrays.sort(merged);
        int total = merged.length;
        
        if (total % 2 == 1) {
            return (double) merged[total / 2];
        } else {
            // FIX 2: Complete the even-length handling logic
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }
    }
}