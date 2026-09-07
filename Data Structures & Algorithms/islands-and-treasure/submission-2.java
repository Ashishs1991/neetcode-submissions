class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int row=0 ;row<rows;row++) {
            for(int col=0;col<cols;col++) {
                if(grid[row][col]==0) {
                    q.add(new int[]{row,col});
                }
            }
        }

         if (q.size() == 0) return;
        int[][] dirs = { { -1, 0 }, { 0, -1 },
                        { 1, 0 }, { 0, 1 } };

        while(!q.isEmpty()) {
            int[] node = q.poll();

            int row = node[0];
            int col = node[1];

            for(int[] dir : dirs) {
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if (newRow >= rows || newCol >= cols || newRow < 0 || newCol < 0 || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                q.add(new int[]{newRow,newCol});

                grid[newRow][newCol] = grid[row][col] + 1;
            }
        }
    }
}
