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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp=new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++)
        {
            temp[i][0]=intervals[i][0];
            temp[i][1]=intervals[i][1];
        }
        temp[intervals.length][0]=newInterval[0];
        temp[intervals.length][1]=newInterval[1];
        
        return merge(temp);
        
    }
}