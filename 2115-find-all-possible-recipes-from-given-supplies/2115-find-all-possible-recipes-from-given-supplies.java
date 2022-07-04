class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        //stores recipes formed till now
         HashSet<String> result=new HashSet<>();
        
        //stores supplies available to see in O(1)
        HashSet<String> supplySet=new HashSet<>();
        for(String s:supplies)
            supplySet.add(s);
  
    // Keep iterating till you cannot add new supplies
    // think what happens when sandwich comes before bread
       boolean keepIterating=true;
        while(keepIterating)
        {
            // check if a recipe can be formed
            // a recipe can be formed only if all ingredients present
            // if after total array iterations, the supply set size has not increased then the next iteration will not make sense
             int prev=supplySet.size();
             keepIterating=false;
             for(int i=0;i<recipes.length;i++)
             {
                 boolean flag=true;
                String curr=recipes[i];
                 
                 // if a recipe is already made, no sense to reiterate
                 if(!result.contains(curr))
                 {               
                    
                List<String> list=ingredients.get(i);
               
                for(int j=0;j<list.size();j++)
                {
                if(!supplySet.contains(list.get(j)))
                {
                    flag=false;
                    break;
                }
                
                }
                 }
       
            if(flag==true)
            {
                supplySet.add(curr);
                result.add(curr);
                
            }
            if(prev<supplySet.size() && result.size()<recipes.length)
                    keepIterating=true;
        }
            
    }
        List<String> ans=new ArrayList<>();
        for(String s:result)
            ans.add(s);
        
        return ans;
    }
}