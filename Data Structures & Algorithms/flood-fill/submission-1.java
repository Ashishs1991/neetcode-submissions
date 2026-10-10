class Solution {
    public int[][] floodFill(
            int[][] image,
            int sr,
            int sc,
            int color
    ) {
        int originalColor = image[sr][sc];

        // Prevent repeatedly visiting pixels when the color is unchanged.
        if (originalColor == color) {
            return image;
        }

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(image, newRow, newCol, originalColor)) {
                    // Mark before inserting to prevent duplicate visits.
                    image[newRow][newCol] = color;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }

    private boolean isValid(
            int[][] image,
            int row,
            int col,
            int originalColor
    ) {
        return row >= 0
                && row < image.length
                && col >= 0
                && col < image[0].length
                && image[row][col] == originalColor;
    }
}