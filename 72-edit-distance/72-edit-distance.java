class Solution {
    public int minDistance(String word1, String word2) {
        
        int n=word1.length();
        int m=word2.length();
        
        int[][] dp=new int[n][m];
        
        for(int row[]: dp)
            Arrays.fill(row,-1);
        
        return f(word1,word2,n-1,m-1,dp);
        
    }
    
   int f(String x,String y,int i,int j,int[][] dp)
   {
       if(i<0)
           return j+1;
       if(j<0)
           return i+1;
       if(dp[i][j]!=-1)
           return dp[i][j];
       
       if(x.charAt(i)==y.charAt(j))
           return dp[i][j]= f(x,y,i-1,j-1,dp);
       else
           return dp[i][j]=1+Math.min(f(x,y,i-1,j-1,dp),Math.min(f(x,y,i-1,j,dp),f(x,y,i,j-1,dp)));
   }
}