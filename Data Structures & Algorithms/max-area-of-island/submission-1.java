class Solution {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int max = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int row=0;row<rows;row++) {
            for(int col=0; col<cols;col++) {
                if(grid[row][col]!=0 && !visited[row][col]) {
                    max = Math.max(max, dfs(grid,visited,row,col));
                }
            }
        }

        return max;
    }


    public int dfs(int[][] grid,boolean[][] visited,int row,int col) {
        if(row<0 || row>= grid.length || col<0 || col>= grid[0].length || visited[row][col] || grid[row][col]==0) {
            return 0;
        }


        visited[row][col] = true;
        int area = 1;

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            area += dfs(grid,visited,newRow,newCol);
        }


        return area;
    }
}
