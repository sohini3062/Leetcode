// for negative numbers to work use: 
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int a, int b) {
        int n=nums.length;
        int[] prefix=new int[n+1];
        prefix[0]=0;
        int ans=Integer.MIN_VALUE;
        int left=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+nums[i];
        }


        // left->a length right->b length
        for(int i=a;i+b<=n;i++)
        {
                left=Math.max(left,prefix[i]-prefix[i-a]);
                ans=Math.max(ans,left+prefix[i+b]-prefix[i]);
        }

        // left->b length right->a length
         left=Integer.MIN_VALUE;
        for(int i=b;i+a<=n;i++)
        {
                left=Math.max(left,prefix[i]-prefix[i-b]);
                ans=Math.max(ans,left+prefix[i+a]-prefix[i]);
        }

        return ans;
    }
}