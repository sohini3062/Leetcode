class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int len=strs.length;
        
        int[][][]dp=new int[len+1][m+1][n+1];
        
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++)
        {
            int count=0;
            for(int j=0;j<strs[i].length();j++)
            {
                char c=strs[i].charAt(j);
                if(c=='1')
                    count++;                    
            }
            map.put(strs[i],count);
        }
        
       // System.out.println(map);
        
       int ans=0;
    
        for(int i=1;i<=len;i++)
        {
            int ones=map.get(strs[i-1]);
            int zeroes=strs[i-1].length()-ones;
            
            for(int j=0;j<=m;j++)
            {
                
                for(int k=0;k<=n;k++)
                {
                    dp[i][j][k]=dp[i-1][j][k];
                    
                    if(j-zeroes>=0 && k-ones>=0)
                        dp[i][j][k]=Math.max(dp[i][j][k],1+dp[i-1][j-zeroes][k-ones]);
                    
                    ans=Math.max(ans,dp[i][j][k]);
                }
            }
        }
        
        return ans;
        
        
    }
}