class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        
        int sum = 0;
        for (int i = 0; i < n; i++) 
            sum += nums[i];
        int req = sum - x;
        
        if (req < 0)
            return -1;
        if (req == 0)
            return n;
        
        int i = 0, j = 0;
        
        int max = 0;
        while (j < n) {
            req=req-nums[j];
            j++;
            
            while (req < 0)
                req += nums[i++];
            
            if (req == 0)
                max = Math.max(max, j-i);
        }
        
        return max == 0 ? -1 : n - max;
    }
}