class Solution {
    public boolean backspaceCompare(String s, String t) {
            StringBuilder sb=new StringBuilder();
            StringBuilder tb=new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                sb.append(s.charAt(i));
                if(s.charAt(i)=='#')
                {
                    int pos=sb.length();
                    sb.deleteCharAt(pos-1);
                    if(sb.length()!=0)
                        sb.deleteCharAt(sb.length()-1);
                }
                
            }
         for(int i=0;i<t.length();i++)
            {
                tb.append(t.charAt(i));
                if(t.charAt(i)=='#')
                {
                    int pos=tb.length();
                    tb.deleteCharAt(pos-1);
                    if(tb.length()!=0)
                        tb.deleteCharAt(tb.length()-1);
                }
                
         }
        return sb.toString().equals(tb.toString());
        
    }
}