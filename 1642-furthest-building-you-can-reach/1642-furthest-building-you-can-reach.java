class Solution {
    
    // only use ladder when cant use bricks
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int jumps=0;
        int n=arr.length;
        for(int i=0;i<arr.length-1;i++)
        {
            jumps=arr[i+1]-arr[i];
            if(jumps<=0)
                continue;
            else
            {
                bricks-=jumps;
                pq.add(jumps);
                if(bricks<0)
                {
                    bricks+=pq.poll();
                    if(ladders>0) ladders--;

                    else
                    {
                       return i;
                    }
                }
            }
        }

       return n-1;
        





    }
}