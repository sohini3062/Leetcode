class Solution {
    public int findUnsortedSubarray(int[] nums) {
       /*Previous solution was done by sorting
       Time Complexity: O(nlogn)
       Space Complexity: O(1) */
      // Two Pointer Approach
      int n=nums.length;
      int max=Integer.MIN_VALUE;
      int min=Integer.MAX_VALUE;
      int hi=0;
      int lo=1;
      int left=0;
      int right=n-1;
      while(left<n)
      {
          if(nums[left]<max)
              hi=left;
          if(nums[right]>min)
              lo=right;
          max=Math.max(max,nums[left]);
          min=Math.min(min,nums[right]);
          left++;
          right--;
      }
    
    return hi-lo+1;
        
        
    }
}