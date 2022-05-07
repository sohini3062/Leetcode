
class Solution {
    long MOD=1000000007;
    public long myPow(long x, long nn) {
        long n=nn;
        if(n<0)
        {
            n=(-1)*n;
            x=1/x;
        }
        long res=1;
        while(n>0)
        {
            if(n%2==1){
                res=res*x%MOD;
                res=res%MOD;
            }
            x=x*x;
            x=x%MOD;
            n>>=1;
        }
        return res%MOD;
        
    }
    public long inverse(long x)
    {
        return myPow(x,MOD-2);
    }
    public ArrayList<Long> computeHash(String s){
        ArrayList<Long> prefix=new ArrayList<>();
        long prime=31;
        long power=0,hash=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            hash+=(myPow(prime,power)*(c-'a'+1))%MOD;
            hash%=MOD;
            prefix.add(hash);
            power++;
        }
        return prefix;
    }
    public long computeFull(String s)
    {
        long prime=31;
        long power=0,hash=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            hash+=(myPow(prime,power)*(c-'a'+1))%MOD;
            hash%=MOD;
            power++;
        }
        return hash;        
    }
    public int strStr(String haystack, String needle) {
        if(needle==null)
            return -1;
        if(needle.length()>haystack.length())
            return -1;
        ArrayList<Long> hash_list=computeHash(haystack);
        int l=0;
        int r=needle.length()-1;
        int n=haystack.length();
        long needle_hash=computeFull(needle);
        System.out.println(needle_hash);
        System.out.println(hash_list);
        while(r<n)
        {
            long curr_hash=0;
            if(l==0)
            {
                curr_hash=(hash_list.get(r)+MOD)%MOD;
                curr_hash=(curr_hash*inverse(myPow(31,l)));
                curr_hash=curr_hash%MOD;
            }
            else
            {
                curr_hash=(hash_list.get(r)-hash_list.get(l-1)+MOD)%MOD;
                curr_hash=(curr_hash*inverse(myPow(31,l)))%MOD;
                curr_hash=curr_hash%MOD;
            }
            if(curr_hash==needle_hash)
                return l;
            l++;
            r++;
        }
        return -1;
        
        
    }
}