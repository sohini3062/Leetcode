class Solution {
    int[] pref;
    int sum;
    Random random=new Random();
    public Solution(int[] w) {
        pref=new int[w.length];
        pref[0]=w[0];
        for(int i=1;i<w.length;i++)
            pref[i]=pref[i-1]+w[i];
        
        sum=pref[pref.length-1];
        
        
        
        
    }
    
    public int pickIndex() {
        
        int left=0;
        int right=pref.length-1;
        int target=1+random.nextInt(sum);
        int ans=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            
            if(pref[mid]==target)
                return mid;
            if(pref[mid]<target)
            {
              
                left=mid+1;
            }
            else
            {
                ans=mid;
                right=mid-1;
            }
        }
        
        return ans;
        
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */