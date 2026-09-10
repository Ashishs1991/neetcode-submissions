class Solution {
    int ROWS, COLS;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        //we start at the boundary
        for(int col = 0;col<COLS;col++) {
            if(board[0][col] =='O') {
                dfs(board,0,col);
            }
            if(board[ROWS-1][col]=='O') {
                 dfs(board,ROWS-1,col);
            }
            
           
        }

        for(int row = 0;row<ROWS;row++) {
            if(board[row][0] == 'O') {
                dfs(board,row,0);
            }
            if(board[row][COLS-1]=='O') {
                dfs(board,row,COLS-1);
            }
            
        }

        for(int row =0;row<ROWS;row++) {
            for(int col =0;col<COLS;col++) {
                if(board[row][col] == '*') {
                    board[row][col] ='O';
                }

                else if(board[row][col]=='O') {
                    board[row][col] ='X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row,int col) {
        board[row][col] = '*';

        for(int[] dir : dirs) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];

            if(newRow<0 || newRow>=ROWS || newCol<0 || newCol>=COLS || board[newRow][newCol]=='X'
            || board[newRow][newCol] =='*') {
                continue;
            }

            dfs(board,newRow,newCol);
        }
    }
}
