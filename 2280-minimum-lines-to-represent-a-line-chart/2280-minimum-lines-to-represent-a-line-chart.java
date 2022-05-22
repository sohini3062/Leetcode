import java.math.BigDecimal;
class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        Arrays.sort(stockPrices,(a,b)->(a[0]-b[0]));
        if(stockPrices.length==1)
            return 0;
        
        if(stockPrices.length==2)
            return 1;
        
        int ans=1;
        for(int i=2;i<stockPrices.length;i++)
        {
            int x1=stockPrices[i][0];
            int y1=stockPrices[i][1];
            int x2=stockPrices[i-1][0];
            int y2=stockPrices[i-1][1];
            int x3=stockPrices[i-2][0];
            int y3=stockPrices[i-2][1];
            
            long p1=(y2-y3)*(x1-x2);
            long p2=(y1-y2)*(x2-x3);
            
            if(p1!=p2)
                    ans++;
            
        }
        return ans;
        
    }
}