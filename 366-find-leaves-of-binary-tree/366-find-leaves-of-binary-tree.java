/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        int height;
        int value;
        Pair(int height,int value)
        {
            this.height=height;
            this.value=value;
        }
        Pair(){
            
        }
    }
    public int height(TreeNode root)
    {
        if(root==null) return -1;
        int leftH=height(root.left);
        int rightH=height(root.right);
        
        int curr=Math.max(leftH,rightH)+1;
        arr.add(new Pair(curr,root.val));
        
        return curr;
    }
    static ArrayList<Pair> arr;
    public List<List<Integer>> findLeaves(TreeNode root) {
        arr=new ArrayList<>();
        
        height(root);
        
        Collections.sort(arr,(a,b)->(a.height-b.height));
        
        int n=arr.size();
        int h=0;
        int i=0;
        List<List<Integer>> solution = new ArrayList<>();
        
        while(i<n)
        {
            List<Integer> nums = new ArrayList<>();
            while(i<n && arr.get(i).height==h)
            {
                nums.add(arr.get(i).value);
                i++;
            }
            solution.add(nums);
            h++;
        }
        
        return solution;
        
    }
}