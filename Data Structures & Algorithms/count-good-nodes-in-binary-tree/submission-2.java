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
    public int goodNodes(TreeNode root) {
        int maxSoFar = Integer.MIN_VALUE;
        int[] count = new int[1];
        if(root==null) return count[0];
        dfs(root,maxSoFar,count);
        return count[0];       
    }

    public void dfs(TreeNode root,int maxSoFar,int[] count) {
        if(root==null) return;
        if(root.val>=maxSoFar) {
            maxSoFar= Math.max(maxSoFar,root.val);
            count[0]+=1;
        }
        
        dfs(root.left,maxSoFar,count);
        dfs(root.right,maxSoFar,count);
    }
}
