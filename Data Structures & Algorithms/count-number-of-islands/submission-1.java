class Solution {
    public int numIslands(char[][] grid) {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count =0;

        for(int row=0;row<rows;row++) {
            for(int col=0;col<cols;col++) {
                if(grid[row][col]!='0' && !visited[row][col]) {
                    count++;
                    
                    dfs(grid,visited,row,col,directions);
                }
            }
        }  

        return count;
    }

    public void dfs(char[][] grid,boolean[][] visited,int row,int col,int[][] directions) {
        if(row<0 || col<0 || row>= grid.length || col>= grid[0].length || grid[row][col]=='0' || visited[row][col]) {
            return;
        }


        visited[row][col]= true;


        for(int[] direction : directions) {
            int newRow = row+direction[0];
            int newCol = col+direction[1];
            dfs(grid,visited,newRow,newCol,directions);
        }
    }
}
