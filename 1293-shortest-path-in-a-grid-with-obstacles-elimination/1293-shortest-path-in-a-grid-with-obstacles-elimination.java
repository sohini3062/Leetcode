class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m=grid.length;
        int n=grid[0].length;
        int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> queue=new LinkedList<>();
        boolean[][][] visited=new boolean[m][n][k+1];
        int steps=0;
        queue.offer(new int[]{0,0,k});
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            while(size-- >0)
            {
                int[] curr=queue.poll();
                if(curr[0]==m-1 && curr[1]==n-1)
                    return steps;
                for(int[] d: dir)
                {
                    int i=curr[0]+d[0];
                    int j=curr[1]+d[1];
                    int obs=curr[2];
                    
                    if(i>=0 && i<m && j>=0 && j<n)
                    {
                        if(grid[i][j]==0 && !visited[i][j][obs])
                        {
                            queue.offer(new int[]{i,j,obs});
                            visited[i][j][obs]=true;
                        }
                        else
                            if(grid[i][j]==1 && obs>0 && !visited[i][j][obs-1]  )
                            {
                                queue.offer(new int[]{i,j,obs-1});
                                 visited[i][j][obs-1]=true;
                            }
                                
                    }
                    
                }
               
            }
             steps++;
        }
        
        return -1;
        
    }
}