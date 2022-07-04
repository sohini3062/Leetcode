class Solution {
    public String nextClosestTime(String time) {
        
        // convert it to minutes format
        int minutes=Integer.parseInt(time.substring(0,2))*60;
        minutes=minutes+Integer.parseInt(time.substring(3));
        
        HashSet<Integer> set=new HashSet<>();
        
        for(char c:time.toCharArray())
        {
            set.add(c-'0');
        }
        
        while(true)
        {
            int nextTime=(minutes+1)%(24*60);
            
            // convert the time back to military format and check if it contains the same digits
            
            int[] arr={nextTime/60/10, nextTime/60%10, nextTime%60/10, nextTime%60%10};
            
            boolean flag=true;
            for(int x: arr)
            {
                if(!set.contains(x))
                {
                    flag=false;
                    break;
                }
            }
            
            if(flag==true) //found answer
            {
                return arr[0]+""+arr[1]+":"+arr[2]+""+arr[3]+"";
            }
            
            minutes++;
            
        }
        
     
    }
}