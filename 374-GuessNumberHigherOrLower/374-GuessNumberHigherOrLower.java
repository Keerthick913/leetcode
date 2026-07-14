// Last updated: 14/07/2026, 16:15:18
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid; 
            } else if (result == -1) {
                end = mid - 1;
            } else {
            
                start = mid + 1;
            }
        }
        return start;
    }
}