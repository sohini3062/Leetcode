
class Solution {
    
    public long maximumImportance(int n, int[][] roads) {
        
        HashMap<Long,Long> map=new HashMap<>();
        long ans=0;
        
        for(int i=0;i<roads.length;i++)
        {
            long p1=roads[i][0];
            long p2=roads[i][1];
            
            if(map.containsKey(p1))
                map.put(p1,map.get(p1)+1);
            else
                map.put(p1,(long)1);
            
            if(map.containsKey(p2))
                map.put(p2,map.get(p2)+1);
            else
                map.put(p2,(long)1);
            
           
           
        }
        
        ArrayList<Map.Entry<Long, Long> > list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Long, Long> >() {
            public int compare(Map.Entry<Long, Long> o1,
                               Map.Entry<Long, Long> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
       for (Map.Entry<Long, Long> entry : list) {
           
                ans+=(n*entry.getValue());
                n--;
            
        }
        return ans;
        
    }
}