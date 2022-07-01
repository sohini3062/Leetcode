class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int size=s.length();
        int max=0;
        HashSet<Character> set=new HashSet<>();
        while(j<size)
        {
            char c=s.charAt(j);
           if(!set.contains(c))
           {
               set.add(c);
               j++;
           }
            else
            {
                max=Math.max(max,set.size());
                set.remove(s.charAt(i++));
            }
        }
        if(!set.isEmpty())
            max=Math.max(max,set.size());
        return max;
        
    }
}