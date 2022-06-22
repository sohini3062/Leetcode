class Solution {
    class Node implements Comparator<Node>{
        long v;
        long w;
        Node(long v,long w){
            this.v=v;
            this.w=w;
        }
        
        Node(){
            
        }
       
        @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.w < node2.w) 
            return -1; 
        if (node1.w > node2.w) 
            return 1; 
        return 0; 
    } 
        
    }
    long mod=(long)Math.pow(10,9)+7;
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Node>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        for(int i=0;i<roads.length;i++)
        {
            graph.get(roads[i][0]).add(new Node(roads[i][1],roads[i][2]));
            graph.get(roads[i][1]).add(new Node(roads[i][0],roads[i][2]));
        }
        
        long[] dist=new long[n];
        long[] ways=new long[n];
        
        Arrays.fill(dist,Long.MAX_VALUE);
        
        dist[0]=0;
        ways[0]=1;
        
        PriorityQueue<Node> pq=new PriorityQueue<>(n,new Node());
        pq.add(new Node(0,0));
        
         while(!pq.isEmpty()){
            
            Node node=pq.poll();
            long src=node.v;
            long dis=node.w;
            for(Node child:graph.get((int)src))
            {
                long v=child.v;
                long w=child.w;
                if(dis+w<dist[(int)v])
                {
                    dist[(int)v]=dis+w;
                    ways[(int)v]=ways[(int)src];
                    pq.add(new Node(v,dist[(int)v]));
                }
                else if((dis+w)==dist[(int)v])
                    ways[(int)v]=(ways[(int)v]+ways[(int)src])%mod;
            }
        }
        
        return (int)ways[n-1];
        
    }
}