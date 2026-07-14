// Last updated: 14/07/2026, 16:14:55
class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbors = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    islands++; 
                    if (i > 0 && grid[i - 1][j] == 1) {
                        neighbors++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        neighbors++;
                    }
                }
            }
        }
        return (islands * 4) - (neighbors * 2);
    }
}