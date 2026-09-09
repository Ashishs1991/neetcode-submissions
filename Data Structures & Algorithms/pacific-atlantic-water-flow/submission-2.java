class Solution {
        int ROWS, COLS;
        boolean pacific, atlantic;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //one appraoch will be from every cell i check i can reach pacific and atlantic
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        //pacific
        for(int col = 0;col<COLS;col++) {
            //top row
            dfs(heights,pac,0,col);
            // bottom row for atlantic
            dfs(heights,atl,ROWS-1,col);
        }

        for(int row = 0;row<ROWS;row++) {
            //leftest row
            dfs(heights,pac,row,0);
            // Righest Row
            dfs(heights,atl,row,COLS-1);
        }

        for(int row=0;row<ROWS;row++) {
            for(int col =0;col<COLS;col++) {
                if(atl[row][col] && pac[row][col]) {
                    result.add(Arrays.asList(row,col));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights,boolean[][] ocean, int row,int col) {
        ocean[row][col] = true;

        for(int[] dir: directions) {
            int newRow = row+dir[0]; 
            int newCol = col+dir[1];

            if(newRow>=0 && newRow<ROWS && newCol>=0 && newCol<COLS && !ocean[newRow][newCol]
               && heights[newRow][newCol]>= heights[row][col]) {
                    dfs(heights,ocean,newRow,newCol);
               }
        }
    }

    
}
