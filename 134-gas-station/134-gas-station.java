class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalCost=0;
        int totalGas=0;
        
        for(var x: gas)
            totalGas+=x;
        for(var x: cost)
            totalCost+=x;
        
        if(totalCost>totalGas)
            return -1;
        
        int index=0;
        int ans=0;
        
        for(int i=0;i<gas.length;i++)
        {
            ans+=gas[i];
            
            if(ans-cost[i]<0)
            {
                    ans=0;
                    index=i+1;
                    continue;
            }
            else
                ans=ans-cost[i];
                
        }
        return index;
        
    }
}