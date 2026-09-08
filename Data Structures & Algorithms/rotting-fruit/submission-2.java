class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // we will do bfs
        int fresh=0;

        Queue<int[]> q = new LinkedList<>();

        for(int row = 0;row<rows;row++) {
            for(int col=0;col<cols;col++) {
                if(grid[row][col]==2) {
                    q.offer(new int[]{row,col});
                }else if(grid[row][col]==1) {
                    fresh++;
                }
            }
        }


        int mins = 0;

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty() && fresh > 0) {
            int levelSize = q.size();

            for(int i=0;i<levelSize;i++) {
                int[] box = q.poll();
                int row = box[0];
                int col = box[1];

            for(int[] dir : dirs) {
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                
                if(newRow<0 || newRow>=rows || newCol<0 || newCol>= cols || grid[newRow][newCol]!=1) {
                    continue;
                }
                    grid[newRow][newCol] = 2;
                    fresh--;
                    q.offer(new int[]{newRow, newCol});
                }
            }
            mins+=1;
        }
        return fresh == 0 ? mins : -1;
    }
}
