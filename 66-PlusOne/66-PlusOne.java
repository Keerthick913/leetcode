// Last updated: 14/07/2026, 16:17:15
class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse the array from the least significant digit (right to left)
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry needed, we can return early
            }
            
            // If the digit is 9, it becomes 0 and carry propagates to the left
            digits[i] = 0;
        }
        
        // If all digits were 9, we need an extra space (e.g., 99 -> 100)
        // In Java, new int arrays default to all 0s, so we just set the first element to 1
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        
        return newDigits;
    }
}