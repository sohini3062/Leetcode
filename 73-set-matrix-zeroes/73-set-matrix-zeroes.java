class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows=new HashSet<>();
        HashSet<Integer> cols=new HashSet<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // rows->1
        //cols->1
        for(int r: rows)
        {
            for(int i=0;i<matrix[0].length;i++)
                matrix[r][i]=0;
        }
        for(int c:cols)
        {
            for(int i=0;i<matrix.length;i++)
                matrix[i][c]=0;
        }
        
    }
}