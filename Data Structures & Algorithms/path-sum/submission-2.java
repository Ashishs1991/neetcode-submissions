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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum,0);
    }


    public boolean dfs(TreeNode root, int targetSum,int curr) {
        if(root==null) return false;

        // pre order Traversal 
        curr+= root.val;
        if(root.left==null && root.right==null && curr ==  targetSum) return true;
        boolean left = dfs(root.left,targetSum,curr);
        boolean right = dfs(root.right,targetSum,curr);

        return left || right;        
    }
}