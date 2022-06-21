class Solution {
    
    // 2 groups = 2 colors =Bipartite Graph checking
    //create the adjacency list and children should not have same color as neighbours 
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());
        
       for(int[] curr:dislikes)
       {
           graph.get(curr[0]).add(curr[1]);
           graph.get(curr[1]).add(curr[0]);
       }
        
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++)
        {
            if(color[i]==-1)
            {
                if(!isBipartite(graph,n,i,color))
                    return false;
            }
        }
        
        return true;      
    
        
    }
    
    public boolean isBipartite( ArrayList<ArrayList<Integer>> graph,int n,int node,int[] color)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        color[node]=1;
        while(!queue.isEmpty())
        {
            int parent=queue.poll();
            for(Integer child: graph.get(parent))
            {
                if(color[child]==-1)
                {
                    color[child]=1-color[parent];
                    queue.add(child);
                }
                else if(color[child]==color[parent])
                    return false;
            }
        }
        return true;
    }
}