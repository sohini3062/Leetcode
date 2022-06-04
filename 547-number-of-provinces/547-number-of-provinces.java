class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans=0;
     
        for(int i = 0; i < n; ++i) {
            if(!visited[i]) {
                dfs(i, visited, isConnected, n);
                  ans++;
            }
        }
        return ans;     
     }
    
    public void dfs(int u,boolean[] visited,int[][] g,int n)
    {
        visited[u]=true;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false && g[u][i]==1)
                dfs(i,visited,g,n);
        }
    }
}