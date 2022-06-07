class Solution {
    public int kthFactor(int n, int k) {
        if(k == 1)
            return 1;
        
        for(int i = 1; i <= (int)(Math.sqrt((double)(n))); ++i)
        {
            if(n % i == 0)
            {
                --k;
                if(k==0)
                    return i;
            }
        }
      
        for(int i =(int)(Math.sqrt((double)(n))); i >= 1; --i)
        {
            if(n % i == 0)
            {
                if(i * i == n)
                    continue;
                k--;
                if(k== 0)
                    return n / i;
            }
        }
        
        return -1;
    }
}