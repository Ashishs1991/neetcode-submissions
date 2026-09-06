class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        int[] result = new int[1];

        for(int row=0;row<rows;row++) {
            for(int col = 0;col<cols;col++) {
                if(grid[row][col]!=0 && !visited[row][col]) {
                    dfs(grid,visited,directions,row,col,result);
                }
            }
        }
        return result[0];
    }

    public void dfs(int[][] grid,boolean[][] visited,int[][] directions,int row,int col,int[] result) {
        //boundary conditions
        if(row<0 || row>= grid.length || col<0 || col>=grid[0].length || grid[row][col]==0) {
            result[0]+=1;
            return;
        }

        if(visited[row][col]) return;

        visited[row][col] = true;

        for(int[] direction : directions) {
            int newRow = row-direction[0];
            int newCol = col-direction[1];

            dfs(grid,visited,directions,newRow,newCol,result);
        }

    }
}