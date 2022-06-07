class Solution {
    public int maxScore(int[] arr, int k) {
        int n=arr.length;
        
        int left_sum=0;
        int right_sum=0;
        
        for(int i=0;i<k && i<n;i++)
            left_sum+=arr[i];
        
       int end=k-1;
       int ans=left_sum;
        int sum=left_sum;
       for(int i=n-1;i>=n-k;i--)
       {
           // if i take a right element i need to remove a left element
          // System.out.println(i);
           sum=left_sum-arr[end]+arr[i];
           //System.out.println(sum);
           left_sum=left_sum-arr[end]+arr[i];
           end--;
           ans=Math.max(ans,sum);
           
       }
        
        return ans;
        
        
    }
}