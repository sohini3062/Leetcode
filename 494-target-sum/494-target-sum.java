class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum=0;
        int n=nums.length;
        for(int x:nums)
            sum+=x;
        
        if(sum<target)
            
            return 0;
        
        if (((sum-target)%2)==1)
            return 0;
        
        int s2=(sum-target)/2;
        
        
        int[][] dp=new int[n][s2+1];
        
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        
        
        
        return f(nums,s2,n-1,dp);
        
    }
    
    public int f(int[] a,int target,int ind,int[][] dp)
    {
        if(ind == 0){
        if(target==0 && a[0]==0)
            return dp[ind][target]=2;
        if(target==0 || target == a[0])
            return dp[ind][target]=1;
        return 0;
    }
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        
        int notTake=f(a,target,ind-1,dp);
        int take=0;
        if(a[ind]<=target)
            take=f(a,target-a[ind],ind-1,dp);
        
        return dp[ind][target]=take+notTake;
    }
}