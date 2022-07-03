class Pair<U, V> {
        public U first;
        public V second;
        public Pair(U first, V second){
            this.first = first;
            this.second = second;
        }
        public Pair(){
            //default constructor
        }
        
    }
class Logger {
    Queue<Pair<String,Integer>> queue;
    HashSet<String> set;
    public Logger() {
        
        queue=new LinkedList<>();
        set=new HashSet<>();
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        while(queue.size()>0)
        {
            Pair<String,Integer> front = queue.peek();
            if(timestamp-front.second>=10)
            {
                queue.remove();
                set.remove(front.first);
            }
            else break;
        }
        
        if(!set.contains(message))
        {
            Pair<String,Integer> curr=new Pair<>(message,timestamp);
            queue.add(curr);
            set.add(message);
            return true;
        }
        
        return false;
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */