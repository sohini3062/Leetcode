class Solution {
    public int lengthLongestPath(String input) {
        
        Stack<Integer> stack=new Stack<>(); // for keeping track of length of path and path traversed so far
        
        int max=0;
        
        stack.push(0);
        
        for(String s: input.split("\n")) //n signifies new file path or new directory 
        {
            int level=s.lastIndexOf("\t")+1; // new path 
            
            while(level<stack.size()-1)
            {
                stack.pop();
                
            }
            
            int len= stack.peek()+(s.length()-level)+1;
            stack.push(len);
            if(s.contains("."))
                max=Math.max(max,len-1);
            
        }
        
        return max;
        
    }
}