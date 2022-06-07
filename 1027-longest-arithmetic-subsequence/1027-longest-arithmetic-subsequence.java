class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n =nums.length;
        int[][]dp=new int[n+1][1005];
        for(int i=0;i<n+1;i++)
             Arrays.fill(dp[i],1);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1); 
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans;
    }
}