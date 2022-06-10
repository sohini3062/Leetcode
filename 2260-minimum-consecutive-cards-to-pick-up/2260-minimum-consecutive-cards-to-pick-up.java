class Solution {
    public int minimumCardPickup(int[] cards) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < cards.length; i++) 
        {
            int curr = cards[i];
            
            if (map.containsKey(curr)) 
                min = Math.min(min, i - map.get(curr) + 1);
            
            map.put(curr, i);
        }
        
        if(min==Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
        
        
 