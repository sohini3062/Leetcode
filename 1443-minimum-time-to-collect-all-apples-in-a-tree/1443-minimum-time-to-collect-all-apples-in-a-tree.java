class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int[] e:edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int ans=dfs(graph,visited,hasApple,0);
        if(ans==0)
            return 0;
        return ans-2;
      
        
    }
    public int dfs(ArrayList<ArrayList<Integer>> g,boolean[] visited,List<Boolean> hasApple, int u)
    {
        int ans=0;
        visited[u]=true;
        for(int v: g.get(u))
        {
            if(!visited[v])
            {
                ans+=dfs(g,visited,hasApple,v);
            }
        }
            if(ans==0)
            {
                if(hasApple.get(u))
                    ans+=2;
            }
            else
                ans+=2;
            
                
        
        return ans;
    }
}