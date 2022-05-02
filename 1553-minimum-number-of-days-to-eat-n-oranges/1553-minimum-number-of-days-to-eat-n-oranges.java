class Solution {
    public int minDays(int n) {
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        q.add(n);
        int ans=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            ans++;
            for(int i=0;i<size;i++)
            {
                int temp=q.poll();
                if(temp==0)
                    return ans-1;
                if(!set.contains(temp)){
                    set.add(temp);
                if(temp%2==0)
                    q.add(temp/2);
                if(temp%3==0)
                    q.add(temp/3);
                q.add(temp-1);
                }
            }
        }
        return ans;
        
    }
}