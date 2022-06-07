class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int min_index=-1;
        int max_index=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
                min_index=i;
            }
            if(nums[i]>max)
            {
                max=nums[i];
                max_index=i;
            }
        }
        
         if(min_index==max_index) 
             return (Math.min(min_index+1,n-min_index));
        
        else if(min_index>max_index)
            
            return( Math.min( Math.min( n-max_index,min_index+1 ), max_index+1+(n-min_index)));
        else  
            return( Math.min( Math.min( n-min_index,max_index+1 ), min_index+1+(n-max_index) ) );
    }
}