class Solution {
    public int minSumOfLengths(int[] nums, int target) {
        int n=nums.length;

        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);

        HashMap<Integer,Integer> map=new HashMap<>();

        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(sum==target)
                dp[i]=i+1;

            if(map.containsKey(sum-target))
                dp[i]=i-map.get(sum-target);
            
            if(i>0) 
                    dp[i]=Math.min(dp[i],dp[i-1]);
                    
            map.put(sum,i);
        }

        sum=0;
        map.clear();

        for(int i=n-1;i>=0;i--)
        {
            sum+=nums[i];
            if(sum==target)
                ans[i]=n-i;
            if(map.containsKey(sum-target))
                ans[i]=map.get(sum-target)-i;
            if(i<n-1)
                ans[i]=Math.min(ans[i],ans[i+1]);
           map.put(sum,i);
        }
        
    int min=Integer.MAX_VALUE;
    for(int i=n-2;i>=0;i--)
    {
        if(dp[i]!=Integer.MAX_VALUE && ans[i+1]!=Integer.MAX_VALUE)
                min=Math.min(min,dp[i]+ans[i+1]);
    }

    return min==Integer.MAX_VALUE?-1:min;

        
    }
}