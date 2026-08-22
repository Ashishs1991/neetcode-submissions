class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //find row:


        int fR= 0;
        int lR= rows-1;

        while(fR<=lR) {
            int mid = fR+(lR-fR)/2;
              System.out.println("mid -- "+mid);
            if(target<matrix[mid][0]) {
                lR=mid-1;
            }else if(target>matrix[mid][0]) {
                fR=mid+1;
            }else {
                return true;
            }
        }

        if (lR < 0)
            return false;

        System.out.println(fR);
        for(int i=0;i<cols;i++) {
            if(matrix[lR][i]==target) return true;
        }

        return false;
    }
}
