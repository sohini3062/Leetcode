class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n=matrix.length;
        
        int left=matrix[0][0];
        int right=matrix[n-1][n-1];
        
        while(left<right)
        {
            int mid=left+(right-left)/2;
            
            if(count(matrix,mid)>=k)
            {
                right=mid;
                
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
       }
    
    public int count(int[][] matrix,int target)
    {
        int c=0;
        int j=matrix.length-1;
        for(int i=0;i<matrix.length;i++)
        {
            while(j>=0 && target<matrix[i][j])
            {
                j--;
            }
            c+=(j+1);
        }
         return c;
    }
   
}