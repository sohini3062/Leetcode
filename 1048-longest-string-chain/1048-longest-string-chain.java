class Solution {
    public boolean isPredecessor(String x,String y)
    {
        if(x.length()!=(y.length()-1))
            return false;
        boolean flag=true;
        int i=0;
        int j=0;
        while(i<x.length() && j<y.length())
        {
            if(x.charAt(i)==y.charAt(j))
            {
                i++;
                j++;
            }
            else if(flag)
            {
                flag=false;
                j++;
            }
            else break;
        }
        if(flag)
            j++;
        return (i==x.length() && j==y.length());
    }
   
    public int longestStrChain(String[] words) {
       Arrays.sort(words, (a, b)->a.length() - b.length());
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(isPredecessor(words[j],words[i]))
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        Arrays.sort(dp);
        return dp[n-1];
    }
}