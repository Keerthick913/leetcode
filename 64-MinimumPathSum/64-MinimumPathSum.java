// Last updated: 14/07/2026, 16:17:18
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Step 1: Initialize the first row (can only be reached from the left)
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        
        // Step 2: Initialize the first column (can only be reached from above)
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        
        // Step 3: Fill out the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The current cell value becomes itself + the minimum of coming from top or left
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        // The bottom-right corner now holds the minimum path sum
        return grid[m - 1][n - 1];
    }
}