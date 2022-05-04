class Solution {
    public int maxOperations(int[] nums, int k) {
         int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            int complement=k-nums[i];
            if(map.containsKey(complement)){
                ans++;
                int val=map.get(complement);
                if(val==1){
                    map.remove(complement);
                }
                else
                map.put(complement,--val);
            }
            else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return ans;
    }
}