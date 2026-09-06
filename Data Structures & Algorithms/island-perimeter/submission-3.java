class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                // Every land cell initially contributes four sides.
                perimeter += 4;

                // Shared side with the land cell above.
                if (row > 0 && grid[row - 1][col] == 1) {
                    perimeter -= 2;
                }

                // Shared side with the land cell to the left.
                if (col > 0 && grid[row][col - 1] == 1) {
                    perimeter -= 2;
                }
            }
        }

        return perimeter;
    }
}