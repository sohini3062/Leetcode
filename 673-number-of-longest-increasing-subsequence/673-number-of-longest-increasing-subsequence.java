class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int lis[] = new int[n];
        int count[]=new int[n];
        int i, j, max = 0;
        Arrays.fill(lis,1);
         Arrays.fill(count,1);
 
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
            {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                {
                    lis[i] = lis[j] + 1;
                    count[i]=count[j];
                } else
                 if (arr[i] > arr[j] && lis[i] == lis[j] + 1)
                {
                    
                    count[i]+=count[j];
                }
                
            }
        for (i = 0; i < n; i++)
        {
            if (max < lis[i])
                max = lis[i];
           
            
        }
       // System.out.println();
//         for (i = 0; i < n; i++)
//         {
//             if (max < lis[i])
//                 max = lis[i];
//             System.out.print(count[i]+", ");
         
//         }
        int ans=0;
        for (i = 0; i < n; i++)
            if (lis[i]==max)
                ans+=count[i];
 
        return ans;
    }
}