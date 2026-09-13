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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] result = new int[1];
        dfs(root,low,high,result);
        return result[0];
    }

    public void dfs(TreeNode root, int low, int high,int[] result) {
        if(root==null) return;


        dfs(root.left,low,high,result);
        dfs(root.right,low,high,result);
        if(root!=null && root.val<=high && root.val>=low) result[0]+=root.val;
    }
}