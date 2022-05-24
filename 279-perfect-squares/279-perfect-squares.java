class Solution {
    public int numSquares(int n) {
        
      int[] ways=new int[(int)(Math.sqrt(n))];
        
      for(int i=0;i<ways.length;i++)
             ways[i]=(i+1)*(i+1);
        
      int dp[]=new int[n+1];
      dp[0]=0;
      dp[1]=1;
        
      for(int i=2;i<=n;i++)
      {
          int min=Integer.MAX_VALUE;
          for(int j=0;j<ways.length;j++)
          {
             if(ways[j]<=i)
             {
                    min=Math.min(min,dp[i-ways[j]]);
             }
         }
          dp[i]=min+1;
       }
     return dp[n];
        
        
    }
}