class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];

        for(int row=0;row<rows;row++) {
            for(int col=0;col<cols;col++) {
                if(board[row][col]!= word.charAt(0)) continue;
                if(helper(board,row,col,word,0,visited)) return true;
            }
        }
        
        return false;
    }

    public boolean helper(char[][] board,int row,int col,String word,int index,int[][] visited) {

        if(index>=word.length()) return true;
        //negative direction
        if(row>=board.length || row<0 || col<0 || col>=board[0].length || visited[row][col]==1 || board[row][col]!=word.charAt(index)) {
            return false;
        }
        

        if(board[row][col]==word.charAt(index)) index++;

        visited[row][col] =1;
        //find up
        boolean up = helper(board,row-1,col,word,index,visited);
        //find below
        boolean down = helper(board,row+1,col,word,index,visited);
        // find left
        boolean left = helper(board,row,col-1,word,index,visited);
        // find right
        boolean right = helper(board,row,col+1,word,index,visited);

        visited[row][col]=0;
        return up || down || right || left;
    }
}
