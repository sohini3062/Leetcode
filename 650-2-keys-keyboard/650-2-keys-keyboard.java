class Solution {
    public int minSteps(int n) {
        return helper(0,1,n);
    }
    
    public int helper(int copied,int visible,int n)
    {
        if(visible==n)
            return 0;
        int copy=10000;
        int paste=10000;
        
        if(copied!=visible) // if copy is a new operation or not yet pasted
            copy=helper(visible,visible,n); //copy what's on screen
        
        if(copied>0 && visible+copied<=n)
            paste=helper(copied,visible+copied,n);
        
        return Math.min(paste,copy)+1;
            
    }

}