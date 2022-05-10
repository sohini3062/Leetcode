class Solution {
    int MOD=1000000007;
    public int countTexts(String s) {
    
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++)
        {
            dp[i]=dp[i-1]%MOD;
            if(i-2>=0 && s.charAt(i-2)==s.charAt(i-1))
            {
                dp[i]+=dp[i-2];
                dp[i]%=MOD;
                if(i-3>=0 && s.charAt(i-3)==s.charAt(i-1))
                {
                    dp[i]+=dp[i-3];
                    dp[i]%=MOD;
                    if(i-4>=0 && s.charAt(i-4)==s.charAt(i-1) && (s.charAt(i-4)=='9' ||                             s.charAt(i-4)=='7')  )
                     {
                        dp[i]+=dp[i-4];
                        dp[i]%=MOD;
                     }
                        
                }
            }
            
        }
        
        return dp[n];
        
        
    }
}