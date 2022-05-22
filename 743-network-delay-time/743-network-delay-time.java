
class Solution {
    private static class Pair<U extends Comparable<U>, V extends Comparable<V> > implements Comparable<Pair<U, V>> {
        public U first;
        public V second;
        public Pair(U first, V second){
            this.first = first;
            this.second = second;
        }
        public Pair(){
            //default constructor
        }
        /* public Pair<U, V> makePair(U first, V second){
             return new Pair<>(first, second);
         }*/
        @Override
        public int compareTo(Pair<U, V> p){
            int t = first.compareTo(p.first);
            if(t == 0) return second.compareTo(p.second);
            return t;
        }
    }
    HashMap<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    
    
    private void dijkstra(int[] signalReceivedAt, int source, int n) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>();
        Pair obj=new Pair();

        pq.add(new Pair(0, source));

       
        signalReceivedAt[source] = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.remove();

            int currNode = topPair.second;
            int currNodeTime = topPair.first;

            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }

            if (!adj.containsKey(currNode)) {
                continue;
            }
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.first;
                int neighborNode = edge.second;

            
                if (signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
      
        
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dijkstra(signalReceivedAt, k, n);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;

}
}