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
    public int goodNodes1(TreeNode root) {
        int maxSoFar = Integer.MIN_VALUE;
        int[] count = new int[1];
        if(root==null) return count[0];
        dfs(root,maxSoFar,count);
        return count[0];       
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int result = 0;
        if(node.val>=max) {
            result = 1;
            max = Math.max(max,node.val);
        }

        result += dfs(node.left,max);
        result += dfs(node.right,max);

        return result;
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
