class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtracker(ans,temp,n,k,0,0,1);
        return ans;        
    }
    public void backtracker(List<List<Integer>> ans,List<Integer> temp,int n,int k,int curr_sum,int count,int ind){
        if(curr_sum==n && count==k)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(curr_sum > n || count == k  || ind > 9)
            return;
        
        for(int i = ind; i <= 9; ++i)
        {
            curr_sum += i;
            if(curr_sum > n)
                return;
            temp.add(i);
            backtracker(ans,temp,n, k,curr_sum,count+1, i+1);
            temp.remove(temp.size() - 1);
            curr_sum -= i;
        }
        
    }
}