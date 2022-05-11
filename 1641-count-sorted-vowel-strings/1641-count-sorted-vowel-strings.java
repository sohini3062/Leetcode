class Solution {
    public int countVowelStrings(int n) {
        if(n==0)
            return 0;
        StringBuilder sb=new StringBuilder();
        String vowel="aeiou";
        ArrayList<String> ans=new ArrayList<>();
        backtracker(vowel,ans,sb,n,0);
        return ans.size();
        
    }
    public void backtracker(String vowel,ArrayList<String> ans, StringBuilder sb,int n,int index)
    {
        if(sb.length()==n)
        {
            ans.add(sb.toString());
            return;
        }
        for(int i=index;i<5;i++)
        {
            sb.append(vowel.charAt(i));
            backtracker(vowel,ans,sb,n,i);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}