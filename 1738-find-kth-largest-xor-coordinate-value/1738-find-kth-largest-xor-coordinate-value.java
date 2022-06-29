class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(j-1>=0) 
                    matrix[i][j]=(matrix[i][j] ^ matrix[i][j-1]);
                
                if(i-1>=0) 
                    matrix[i][j]=(matrix[i][j] ^ matrix[i-1][j]);
                
                if(i-1>=0 && j-1>=0) 
                    matrix[i][j]=(matrix[i][j] ^ matrix[i-1][j-1]);
                
                
                pq.add(matrix[i][j]);
                
                if(pq.size()>k) 
                    pq.remove();
                
            }
        }
        
        return pq.remove();
        
    }
}