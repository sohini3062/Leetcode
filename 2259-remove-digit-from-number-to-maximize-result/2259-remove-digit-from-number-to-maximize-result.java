class Solution {
    public String removeDigit(String number, char digit) {
        int first_occ=0;
        for(int i=0;i<number.length();i++)
        {
            char dg=number.charAt(i);
            if(dg==digit)
            {
                first_occ= i;
                if(i<number.length()-1 && digit < number.charAt(i+1)) break;
            }
        }
        return number.substring(0,first_occ)+number.substring(first_occ+1);
        
    }
}