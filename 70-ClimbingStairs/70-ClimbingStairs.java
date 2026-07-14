// Last updated: 14/07/2026, 16:17:10
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int oneStepBefore = 2; // ways to reach step 2
        int twoStepsBefore = 1; // ways to reach step 1
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = result;
        }

        return result;
    }
}
