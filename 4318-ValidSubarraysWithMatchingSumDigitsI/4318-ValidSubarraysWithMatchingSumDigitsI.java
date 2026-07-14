// Last updated: 14/07/2026, 16:12:14
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int veltanoric = 0; 
        int validCount = 0;
        for (int l = 0; l < nums.length; l++) {
            long currentSum = 0; 
            for (int r = l; r < nums.length; r++) {
                currentSum += nums[r];
                int lastDigit = (int) (currentSum % 10);
                long temp = currentSum;
                while (temp >= 10) {
                    temp /= 10;
                }
                int firstDigit = (int) temp;
                if (firstDigit == x && lastDigit == x) {
                    validCount++;
                }
            }
        }
        return validCount;
    }
}