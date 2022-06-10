class Solution {
    // 1-> red, -1->blue
    class Edge {
        int vertex, color, distance;
        public Edge(int vertex, int color, int distance) {
            this.vertex = vertex;
            this.color = color;
            this.distance = distance;
        }
    }
        
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        List<List<Edge>> g = new ArrayList<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = 0; i < n; i++) 
            g.add(new ArrayList<>());
        
        for(int i = 0; i < redEdges.length; i++) {
            g.get(redEdges[i][0]).add(new Edge(redEdges[i][1], 1, 0));
        }
        for(int i = 0; i < blueEdges.length; i++) {
            g.get(blueEdges[i][0]).add(new Edge(blueEdges[i][1], -1, 0));
        }
        
        Queue<Edge> q=new LinkedList<>();
        boolean[][] visited = new boolean[n][3];
        
         q.add(new Edge(0, 1, 0));
         q.add(new Edge(0, -1, 0));
        
         while(!q.isEmpty()) {
            Edge edge = q.poll();
            if(ans[edge.vertex]==-1)
                ans[edge.vertex]=edge.distance;
             else
                 ans[edge.vertex]=Math.min(ans[edge.vertex], edge.distance);
            
            visited[edge.vertex][edge.color+1] = true;
            
            for(Edge u : g.get(edge.vertex)) {
                if(!visited[u.vertex][u.color+1] && u.color==-edge.color) {
                    q.add(new Edge(u.vertex, u.color, edge.distance + 1));
                }
            }
            
        }
        
        return ans;
    }
}
    
        