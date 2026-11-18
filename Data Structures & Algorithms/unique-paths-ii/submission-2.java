class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROWS = obstacleGrid.length;
        int COLS = obstacleGrid[0].length;

        int[][] result = new int[ROWS][COLS];

        for(int r=0;r<ROWS;r++) {
            if(obstacleGrid[r][0] == 1) {
                break;
            }
            result[r][0] = 1;
        }

        for(int c=0;c<COLS;c++) {
            if(obstacleGrid[0][c] == 1) {
                break;
            }
            result[0][c] = 1;
        }

        for(int r=1;r<ROWS;r++) {
            for(int c=1;c<COLS;c++) {
                if(obstacleGrid[r][c]==1) {
                    result[r][c] =0;
                    continue;
                }
                result[r][c] = result[r-1][c] + result[r][c-1];
            }
        }

        return result[ROWS-1][COLS-1];
    }
}