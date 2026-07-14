// Last updated: 14/07/2026, 16:17:14
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop until both strings are fully traversed and there's no carry left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }

            // Append the binary digit (0 or 1)
            sb.append(sum % 2);
            // Calculate the new carry (0 or 1)
            carry = sum / 2;
        }

        // The digits were added in reverse order, so reverse before returning
        return sb.reverse().toString();
    }
}