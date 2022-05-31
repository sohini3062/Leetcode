class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        if(s.length()<k)
            return false;
        long p= (long) (Math.pow(2,k));
        Set<String> set=new HashSet<>();
        
        int i=0;
        int j=0;
        
        StringBuilder sb=new StringBuilder();
        
        int n=s.length();
        while(j<n)
        {
            sb.append(s.charAt(j));
            if(j-i+1==k)
            {
                set.add(sb.toString());
                //System.out.println(sb);
                if(sb.length()>0)
                    sb.deleteCharAt(0);
                i++;
                
            }
            j++;
        }
        
        if(set.size()==p)
            return true;
        return false;
        
    }
}