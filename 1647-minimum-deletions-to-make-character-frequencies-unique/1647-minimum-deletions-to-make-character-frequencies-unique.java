class Solution {
    public int minDeletions(String s) {
        
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(arr[i]);
            }
        }
        int count=0;
        while(pq.size()>1)
        {
            int top=pq.remove();
            if(top==pq.peek())
            {
                if(top-1>0)
                    pq.add(top-1);
                count++;
            }
        }
        return count;
    }
}