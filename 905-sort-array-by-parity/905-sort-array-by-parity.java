class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<j)
        {
            while(nums[i]%2==0 && i<j)
                i++;
            while (nums[j]%2 == 1 && i<j)
                j--;
            if (i < j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j--;
                i++;
            }
        }
      return nums;  
    }
}