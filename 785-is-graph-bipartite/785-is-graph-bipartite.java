class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(color[i]!=0){
                continue;
            }
            color[i] = 1;
            if(!dfs(color, graph, i)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int[] color, int[][] graph, int cur){
        for(int i : graph[cur]){
            if(color[i] == 0){
                color[i] = color[cur]==1?-1:1;
                if(!dfs(color, graph, i)){
                    return false;
                }
            }else if(color[i]==color[cur]){
                return false;
            }
        }
        return true;
    }
}