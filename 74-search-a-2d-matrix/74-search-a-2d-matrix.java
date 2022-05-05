class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m-1;
        int ans=m;
        //remember
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(matrix[mid][0]>target)
            {
                ans=mid; // use this
                right=mid-1;
            } 
            else{
                    left=mid+1;
                }
        }
        ans--;
        if(ans<0)
            return false;
        left=0;
        right=n-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(matrix[ans][mid]==target)
            {
                return true;
            }
            else if(matrix[ans][mid]<target)
            {
                left=mid+1;
            }
            else 
            {
                right=mid-1;
            }
        }
        return false;
        
    }
}