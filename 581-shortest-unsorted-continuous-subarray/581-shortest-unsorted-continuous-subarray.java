class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp=nums.clone();
        Arrays.sort(temp);
        int left=nums.length;//will use min
        int right=0;// will use max
        for(int i=0;i<nums.length;i++)
        {
            if(temp[i]!=nums[i])
            {
                left=Math.min(left,i);
                right=Math.max(right,i);
            }
        }
        if(right-left>=0)
            return right-left+1;
        return 0;
        
    }
}