class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0)
            return new int[0];
        
        Arrays.sort(changed);
        
        int[] ans=new int[changed.length/2];
        int index=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int x: changed)
           map.put(x,map.getOrDefault(x,0)+1);
        
        for(int i=0;i<changed.length;i++)
        {
            
            if(map.containsKey(changed[i]*2) && map.get(changed[i]*2)>0)
            {
                if(changed[i]==0)
                {
                    int freq=map.get(changed[i]);
                    if(freq>1){
                        map.put(changed[i]*2,map.get(changed[i]*2)-2);
                        if(index>=ans.length)
                                break;
                        ans[index++]=changed[i];
                    }
                } else
                if(map.get(changed[i]*2)>=1 && map.get(changed[i])>0){
                    map.put(changed[i]*2,map.get(changed[i]*2)-1);
                    map.put(changed[i],map.get(changed[i])-1);
                    if(index>=ans.length)
                        break;
                    ans[index++]=changed[i];
                }
            }
        }
        if(index!=(changed.length/2))
            return new int[0];
        return ans;
        
        
        
        
        
    }
}