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
   int ans=0;
    public int minCameraCover(TreeNode root) {
        HashSet<TreeNode> visited=new HashSet<>();
        visited.add(null);
      
        dfs(root,null,visited);
        return ans;
        
    }
    public void dfs(TreeNode node,TreeNode parent,HashSet<TreeNode> vis)
    {
        if(node!=null)
        {
            dfs(node.left,node,vis);
            dfs(node.right,node,vis);
        
        if(parent == null && !vis.contains(node) || !vis.contains(node.left) || !vis.contains(node.right)){
           ans++;
            vis.add(node);
            vis.add(node.left);
            vis.add(node.right);
            vis.add(parent);
        }
        }
    }
}