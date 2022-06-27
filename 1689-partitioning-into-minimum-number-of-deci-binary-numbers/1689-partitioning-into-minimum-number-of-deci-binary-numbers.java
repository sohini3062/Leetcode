class Solution {
    public int minPartitions(String n) {
    int ans=0;
    for(char c:n.toCharArray())
    {
        if(c=='9')
            return 9;
        ans=Math.max(c-48,ans);
    }
        
    return ans;
}
}