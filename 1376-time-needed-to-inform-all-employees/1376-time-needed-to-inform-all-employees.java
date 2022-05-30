class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(headID);
        int[] visited=new int[n];
        
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(manager[i]))
                map.put(manager[i],new ArrayList<>());
            
            map.get(manager[i]).add(i);
        }
        
        visited[headID]=0;
        int max=0;
        
        while(!queue.isEmpty())
        {
            int node=queue.remove();
            int time=informTime[node];
            
            if(map.get(node)!=null)
            {
                for(int x: map.get(node))
                {
                    visited[x]=visited[node]+time;
                    max=Math.max(max,visited[x]);
                    queue.add(x);
                }
            }
        }
        
        return max;
        
        
        
    }
}