class Solution {
    public boolean isValidSudoku(char[][] board) {

        //check rows:
        for(int i=0;i<9;i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++) {
                if (board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        //check cols:
        for(int i=0;i<9;i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++) {
                if (board[j][i] == '.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        //check the boxes
        for(int square=0;square<9;square++) {
            HashSet<Character> set = new HashSet<>();
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    int row = (square/3)*3+i;
                    int col = (square%3)*3+j;

                    if(board[row][col]=='.') continue;
                    if(set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                }
            }
        }
        
        return true;
    }
}
