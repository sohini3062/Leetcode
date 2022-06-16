class Solution {
    public String longestPalindrome(String s) {
        
        int n=s.length();
        int max=1;
        int l,r;
        int start=0;
        for(int i=0;i<n;i++)
        {
            l=i-1;
            r=i+1;
            
            while(r<n && s.charAt(r)==s.charAt(i))
                r++;
            while(l>=0 && s.charAt(l)==s.charAt(i))
                l--;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                l--;
                r++;
            }
            int len=r-l-1;
            if(len>max)
            {
                max=len;
                start=l+1;
            }
            
        }
        
        return s.substring(start,start+max);
        
    }
}