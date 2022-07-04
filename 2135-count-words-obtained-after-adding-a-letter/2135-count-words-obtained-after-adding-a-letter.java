class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        HashSet<String> start=new HashSet<>();
        for(String s: startWords)
        {
            char[] c=s.toCharArray();
            Arrays.sort(c);
            s=String.valueOf(c);
            start.add(s);
        }
        
        for(int i=0;i<targetWords.length;i++)
        {
            String s=targetWords[i];
            char[] c=s.toCharArray();
            Arrays.sort(c);
            s=String.valueOf(c);
            targetWords[i]=s;            
        }
        int ans=0;
        boolean flag=false;
        
        for(int i=0;i<targetWords.length;i++)
        {
            flag=false;
            for(int j=0;j<targetWords[i].length();j++)
            {
                
                String s=targetWords[i].substring(0,j)+targetWords[i].substring(j+1);
                if(start.contains(s))
                {
                    flag=true;
                    break;
                }
            }
            if(flag==true)
                ans++;
        }
        
        return ans;
    }
}