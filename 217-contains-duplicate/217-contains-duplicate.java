class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set= new HashSet<>();
        
        // add elements from the array to the set
        
        for(int i=0;i<nums.length;i++)
        {
            
            set.add(nums[i]);
        }
        
        int set_length=set.size();
        int array_length=nums.length;
        
        return (set_length!=array_length);
        
        
        
        
        
    }
}