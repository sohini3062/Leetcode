class Solution {
    public String largestGoodInteger(String num) {
      String[] pos={"999","888","777","666","555","444","333","222","111","000"};
        for(String x:pos)
        {
            if(num.indexOf(x)>=0)
                return x;
                
        }
        return "";
        
        
    }
}