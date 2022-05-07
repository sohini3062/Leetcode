​MAY 7th LeetCoding Challenge:
Two Approaches: Monotonic Stack and Next Greater Element on the Right

Done Using Monotonic Stack. Here the next greater element approach is added.


class Solution {

  public boolean find132pattern(int[] nums) {
    
        Stack<Integer> st = new Stack<>();
        
        int ith_element= Integer.MIN_VALUE;
        
        for(int i = nums.length - 1; i >= 0; i--){
        
            if(nums[i] < ith_element) 
            
                return true;
                
            while(!st.isEmpty() && st.peek() < nums[i]) 
            
            {
            
                ith_element = st.pop();
                
            }
            
            st.push(nums[i]);
        }
        
        return false;
    }
}
