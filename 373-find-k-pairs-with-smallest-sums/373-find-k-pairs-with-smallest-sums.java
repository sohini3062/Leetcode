class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->(b.get(0)+b.get(1))-(a.get(0)+a.get(1))); // maxheap cause i need kth smallest elements
        
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                Integer sum=nums1[i]+nums2[j];
                pq.add(Arrays.asList(nums1[i],nums2[j],sum));
                if(pq.size()>k)
                {
                   pq.poll();
                }
                if(sum > pq.peek().get(2))
                    break;
            }
        }
        
        List<List<Integer>> ans=new ArrayList<>();
        
        while(pq.size()>0)
        {
            ans.add(Arrays.asList(pq.peek().get(0),pq.peek().get(1)));
            pq.poll();
            
        }
        
        return ans;
    }
}