class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->(a[1]-b[1]));
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        int time=0;
        
        for(int i=0;i<courses.length;i++)
        {
            int curr_dur=courses[i][0];
            int limit=courses[i][1];
            
            if(curr_dur+time<=limit)
            {
                pq.add(curr_dur);
                time=time+curr_dur;
            }
            else if(!pq.isEmpty() && pq.peek()>curr_dur)
            {
                    time+=curr_dur-pq.poll();
                    pq.add(curr_dur);
            }
        }
        
        return pq.size();
        
    }
}