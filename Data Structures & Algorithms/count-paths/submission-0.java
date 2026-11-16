class Solution {
    public int uniquePaths(int m, int n) {
        int[][] data = new int[m][n];

        // add 1 to first ro and first col

        for(int i=0;i<m;i++) {
            data[i][0] =1;
        }

        for(int i=0;i<n;i++) {
            data[0][i] =1;
        }

        for(int i=1;i<m;i++) {
            for(int j = 1;j<n;j++) {
                data[i][j] = data[i-1][j] + data[i][j-1];
            }
        }

        return data[m-1][n-1];
    }
}
