class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        
       HashMap<String,Integer> map=new HashMap<>();
       for(int i=0;i<words.length;i++)
       {
           map.put(words[i],map.getOrDefault(words[i],0)+1);
       }
        ArrayList<String> arr=new ArrayList<>(map.keySet());
        Collections.sort(arr,new Comparator<String>()
                         {
                             @Override
                             public int compare(String o1,String o2)
                             {
                                 if(map.get(o1)==map.get(o2))
                                            return o1.compareTo(o2);
                                 return map.get(o2)-map.get(o1);
                             }
                         });
    List<String> ans=new ArrayList<>();
    for(int i=0;i<k;i++)
        ans.add(arr.get(i));
    return ans;
        
    }
}