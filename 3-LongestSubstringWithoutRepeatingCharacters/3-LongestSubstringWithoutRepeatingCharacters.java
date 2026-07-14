// Last updated: 14/07/2026, 16:18:02
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the last seen index of each character
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Left boundary of the sliding window
        
        // Iterate with the right boundary of the sliding window
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already inside the current window,
            // shrink the window by moving the left pointer past its previous index
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            
            // Update or insert the last seen position of the character
            charMap.put(currentChar, right);
            
            // Calculate the window size and update maxLength if it's larger
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}