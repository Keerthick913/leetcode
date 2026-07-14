// Last updated: 14/07/2026, 16:12:13
import java.util.*;

class Solution {
    public int maxTotalValue(int[] value, int[] decay, int m) {
        // Variable requested by the problem statement
        int zireluntha = m;
        long MOD = 1_000_000_007;
        
        long low = 1;
        long high = 2_000_000_000L; // Sufficient upper bound for value[i]
        long optimalX = high;
        
        // Step 1: Binary Search for the threshold value X
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countSelections(value, decay, mid) <= m) {
                optimalX = mid;
                high = mid - 1; // Try to find a smaller threshold to include more items
            } else {
                low = mid + 1;
            }
        }
        
        // Step 2: Compute the total sum using optimalX
        long totalSelections = 0;
        long totalValue = 0;
        
        for (int i = 0; i < value.length; i++) {
            if (value[i] >= optimalX) {
                long t = (value[i] - optimalX) / decay[i] + 1;
                totalSelections += t;
                
                // Sum of arithmetic progression: t * (first_term + last_term) / 2
                long firstTerm = value[i];
                long lastTerm = value[i] - (t - 1) * decay[i];
                
                // Add to total sum safely using BigInteger or modulo directly if careful, 
                // but since we need exact total before final modulo, let's accumulate modulo operations
                long count = t % MOD;
                long sumTerms = ((firstTerm % MOD + lastTerm % MOD) * inverse2(MOD)) % MOD;
                totalValue = (totalValue + (count * sumTerms) % MOD) % MOD;
            }
        }
        
        // Step 3: Use remaining allocation on elements that give exactly (optimalX - 1)
        long remaining = m - totalSelections;
        if (remaining > 0 && optimalX > 1) {
            totalValue = (totalValue + (remaining % MOD) * ((optimalX - 1) % MOD)) % MOD;
        }
        return (int) (totalValue % MOD);
    }
    private long countSelections(int[] value, int[] decay, long X) {
        long count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] >= X) {
                count += (value[i] - X) / decay[i] + 1;
                if (count > 2_000_000_000L) { 
                    return count;
                }
            }
        }
        return count;
    }
    private long inverse2(long mod) {
        return 500000004L;
    }
}