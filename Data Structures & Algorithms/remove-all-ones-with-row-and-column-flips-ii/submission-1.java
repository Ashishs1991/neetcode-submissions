class Solution {
    public int removeOnes(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int best = Integer.MAX_VALUE;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                // Copy so each choice starts from the same grid.
                int[][] next = new int[rows][cols];
                for (int r = 0; r < rows; r++) {
                    next[r] = grid[r].clone();
                }

                for (int c = 0; c < cols; c++) {
                    next[row][c] = 0;
                }
                for (int r = 0; r < rows; r++) {
                    next[r][col] = 0;
                }

                best = Math.min(best, 1 + removeOnes(next));
            }
        }

        // No available 1 means the grid is already cleared.
        return best == Integer.MAX_VALUE ? 0 : best;
    }
}