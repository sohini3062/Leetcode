class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        List<String> ans=new ArrayList<>();
        String[] ref=new String[10];
        ref[2]="abc";
        ref[3]="def";
        ref[4]="ghi";
        ref[5]="jkl";
        ref[6]="mno";
        ref[7]="pqrs";
        ref[8]="tuv";
        ref[9]="wxyz";
        StringBuilder sb=new StringBuilder();
        backtracker(digits,ref,ans,0,sb);
        return ans;
    }
    
    public void backtracker(String s,String[] ref,List<String> ans,int index,StringBuilder sb)
    {
      
        if(index==s.length())
        {
            ans.add((sb.toString()));
            return;
        }
        String curr=ref[s.charAt(index)-'0'];
        for(int i=0;i<curr.length();i++)
        {
            char c=curr.charAt(i);
            sb.append(c);
            backtracker(s,ref,ans,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}