class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int ans=0;
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i;j<=n-1;j++)
            {
                if(i==j)
                {
                    dp[i][j]=1;
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        if(dp[i+1][j-1]==1)
                            dp[i][j]=1;
                        else
                        if(j-1<i+1)
                            dp[i][j]=1;
                        else
                            dp[i][j]=0;
                    }
                    else
                        dp[i][j]=0;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               ans+=dp[i][j];
            }
        }
        return ans;
        
        
    }
}