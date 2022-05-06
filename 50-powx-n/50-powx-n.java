class Solution {
    public double myPow(double x, int nn) {
        long n=nn;
        if(n<0)
        {
            n=(-1)*n;
            x=1/x;
        }
        double res=1;
        while(n>0)
        {
            if(n%2==1)
                res=res*x;
            x=x*x;
            n>>=1;
        }
        return res;
        
    }
}