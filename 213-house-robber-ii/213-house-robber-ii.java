class Solution {
    public int maximumNonAdjacent(ArrayList<Integer> arr)
    {
        int n=arr.size();
        int prev=0;
        if(arr.size()>0)
                prev=arr.get(0);
        int prev2=0;
        for(int i=1;i<n;i++)
        {
            int take=arr.get(i);
            if(i>1)
                take+=prev2;
            int notTake=prev;
            int curr=Math.max(take,notTake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        ArrayList<Integer> temp1=new ArrayList<>();
        ArrayList<Integer> temp2=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0)
                temp1.add(nums[i]);
            if(i!=nums.length-1)
                temp2.add(nums[i]);
        }
        return Math.max(maximumNonAdjacent(temp1),maximumNonAdjacent(temp2));
        
        
    }
}