class Solution {

    boolean[][] visited;
    private int[][] dp;

    public int minPathSum(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }
        

        visited = new boolean[rows][cols];

        return helper(grid,0,0,rows,cols);
    }

    public int helper(int[][] grid,int startR,int startC,int rows,int cols) {
        if(startR==rows-1 && startC==cols-1) {
            return grid[startR][startC];
        }

        //
        if(startR>=rows || startC>=cols || visited[startR][startC]) {
            return Integer.MAX_VALUE;
        }

        if (dp[startR][startC] != -1) {
            return dp[startR][startC];
        }

        visited[startR][startC] = true;
        //down
        int down = helper(grid,startR+1,startC,rows,cols);
        // right
        int right = helper(grid,startR,startC+1,rows,cols);

        visited[startR][startC] = false;

        return dp[startR][startC]= grid[startR][startC] + Math.min(down,right);
    }
}