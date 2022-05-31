class Solution {
    public int longestSubarray(int[] nums, int k) {
       PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        int i=0;
        int j=0;
        int ans=0;

        while(j<nums.length)
        {
            minHeap.add(nums[j]);
            maxHeap.add(nums[j]);

            int min=minHeap.peek();
            int max=maxHeap.peek();

            if(Math.abs(max-min)<=k)
            {
                j++;
                ans=Math.max(ans,j-i);

            }
            else
            {
                minHeap.remove(nums[i]);
                maxHeap.remove(nums[i]);
                i++;
                j++;
            }
        }

        return ans;
        
    }
    
}