class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
     public boolean find132pattern(int[] nums) {
        Stack<Pair> stack=new Stack<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(!stack.isEmpty()){
                min=Math.min(min,stack.peek().first);
            }
            while(!stack.isEmpty() && (nums[i]>stack.peek().first)){
                stack.pop();
            }
            if(!stack.isEmpty() && (stack.peek().first> nums[i]) && (stack.peek().second<nums[i]))
                return true;

            stack.push(new Pair(nums[i],min));
        }
        return false;


    }
}