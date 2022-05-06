class Pair{
    char c;
    int freq;
    public Pair(char c,int freq)
    {
        this.c=c;
        this.freq=freq;
    }
}
class Solution {
    class Pair{
    char c;
    int freq;
    public Pair(char c,int freq)
    {
        this.c=c;
        this.freq=freq;
    }
}
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(!stack.isEmpty() && stack.peek().c==curr){
                stack.peek().freq++;
            }
            else{
                stack.push(new Pair(curr,1));
            }
            if (stack.peek().freq == k) {
                stack.pop();
            }
                
        }
       StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
        {
            Pair current=stack.pop();
            for(int i=0;i<current.freq;i++){
                sb.append(current.c);
            }
        }
        return sb.reverse().toString();
        
        
    }
}