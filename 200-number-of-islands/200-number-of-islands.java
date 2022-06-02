class Solution {
    public int numIslands(char[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==false)
                {
                    dfs(grid,visited,i,j,n,m);
                    ans++;
                }
            }
        }
        return ans;
        
    }
    
    public void dfs(char[][] grid, boolean[][] visited,int r,int c,int n,int m)
    {
        visited[r][c]=true;
        
        if(r>0 && grid[r-1][c]=='1' && !visited[r-1][c])
            dfs(grid,visited,r-1,c,n,m);
        
        if(r<n-1 && grid[r+1][c]=='1' && !visited[r+1][c])
            dfs(grid,visited,r+1,c,n,m);
        
        if(c>0 && grid[r][c-1]=='1' && !visited[r][c-1] )
            dfs(grid,visited,r,c-1,n,m);
        
         if(c<m-1 && grid[r][c+1]=='1' && !visited[r][c+1] )
            dfs(grid,visited,r,c+1,n,m);
    }
}