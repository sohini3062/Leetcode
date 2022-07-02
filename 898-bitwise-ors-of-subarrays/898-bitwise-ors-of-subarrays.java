class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        HashSet<Integer> prev=new HashSet<>();
        HashSet<Integer> ans=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> curr=new HashSet<>();
            curr.add(arr[i]);
            for(Integer x: prev)
                curr.add(x|arr[i]);
            for(Integer x: curr)
                ans.add(x);
            
            prev=curr;
            
                
        }
        
        return (int)ans.size();
        
    }
}