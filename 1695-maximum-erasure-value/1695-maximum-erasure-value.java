class Solution {
    // maximum sum of a unique element subarray
    public int maximumUniqueSubarray(int[] nums) {
        
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        int i=0;
        int j=0;
        int sum=0;
        int max=0;
        while(j<n)
        {
            if(!set.contains(nums[j]))
            {
                sum+=nums[j];
                set.add(nums[j]);
            }
            else
            {
                max=Math.max(sum,max);
                while(set.contains(nums[j]) && i<n)
                {
                    set.remove(nums[i]);
                    sum=sum-nums[i];
                    i++;
                }
                set.add(nums[j]);
                sum+=nums[j];
            }
            j++;
            
        }
        
        return Math.max(sum,max);
        
    }
}