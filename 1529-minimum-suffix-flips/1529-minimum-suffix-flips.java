class Solution {
    public int minFlips(String target) {
        //string s has all zeroes
        char ch='0';
        int flips=0;
        for(int i=0;i<target.length();i++)
        {
            if(target.charAt(i)!=ch)
            {
                flips++;
                ch=target.charAt(i);
            }
        }
        return flips;
        
        
    }
}