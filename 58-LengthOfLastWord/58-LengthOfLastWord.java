// Last updated: 14/07/2026, 16:17:21
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } 
            else if (length > 0) {
                return length;
            }
        }
        
        return length;
    }
}