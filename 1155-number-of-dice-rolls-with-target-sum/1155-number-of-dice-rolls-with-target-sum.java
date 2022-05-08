class Solution {
    int MOD=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        /*  dp[i][j]= total number of ways first i dice to make a sum of j
             dp[0][0]=1
            Initialization : All others are 0
            Transition: dp[i][j]=dp[i][j]+ dp[i-1][j-dice] where dice=1 to k and j-dice>=0
            Final: dp[n][target] */
        dp[0][0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                for(int dice=1;dice<=k;dice++)
                {
                    if(j-dice>=0)
                    {
                        dp[i][j]+=dp[i-1][j-dice];
                        dp[i][j]=dp[i][j]%MOD;
                    }
                        
                }
            }
        }
        return dp[n][target];
        
    }
}