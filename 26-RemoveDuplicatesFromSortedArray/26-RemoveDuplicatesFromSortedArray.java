// Last updated: 14/07/2026, 16:17:35
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        // 'i' keeps track of the position of the last unique element found
        int i = 0; 
        
        // 'j' scans through the array to find new unique elements
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Move the unique element forward
            }
        }
        
        // The number of unique elements is the index 'i' + 1
        return i + 1;
    }
}