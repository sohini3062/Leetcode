class MyStack {
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    int top;
    public MyStack() {
    }
   
    public void push(int x) {
        q1.add(x);
        top=x;
    }
    
    public int pop() {
        while(q1.size()>1){
            top=q1.remove();
            q2.add(top);
        }
        int x=q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return x;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty())return true;
        return false;
    }
}