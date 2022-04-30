class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int curr_row=0;
        int curr_col=matrix[0].length-1;
        while(curr_row<matrix.length && curr_col>=0)
        {
            if(matrix[curr_row][curr_col]==target)
                return true;
            if(matrix[curr_row][curr_col]>target)
            {
                curr_col--;
            }
            else {
                curr_row++;
            }
        }
        return false;
        
    }
}