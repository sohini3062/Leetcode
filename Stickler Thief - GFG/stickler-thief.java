//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
       int[] dp=new int[n];
       dp[0]=arr[0];
       if(n==1)
        return dp[0];
      dp[1]=Math.max(arr[0],arr[1]);
      for(int index=2;index<n;index++)
      {
          int take=Integer.MIN_VALUE;
          int notTake=dp[index-1];
        if(index-2>=0)
            take=arr[index]+dp[index-2];
        dp[index]=Math.max(take,notTake);
      }
     return dp[n-1];
    }
}