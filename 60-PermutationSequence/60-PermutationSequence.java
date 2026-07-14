// Last updated: 14/07/2026, 16:17:19
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int blockSize = factorial[i - 1];
            int index = k / blockSize;
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= blockSize;
        }
        
        return sb.toString();
    }
}