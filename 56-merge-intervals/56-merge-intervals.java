class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        LinkedList<int[]> ans=new LinkedList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(ans.isEmpty() || ans.getLast()[1]<intervals[i][0])
                ans.add(intervals[i]);
            else
            {
                ans.getLast()[1]=Math.max(ans.getLast()[1],intervals[i][1]);
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
        
        
    }
}