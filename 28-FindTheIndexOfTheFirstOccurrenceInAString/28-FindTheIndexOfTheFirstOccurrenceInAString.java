// Last updated: 14/07/2026, 16:17:32
class Solution {
    public int strStr(String haystack, String needle) { 
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the first occurrence index
            }
        }
        
        return -1; // Needle not found
    }
}