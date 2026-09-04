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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{root.val};

        dfs(root,res);

        return res[0];
    }

    public int dfs(TreeNode root,int[] res) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(dfs(root.left,res),0);
        int right = Math.max(dfs(root.right,res),0);

        res[0] = Math.max(res[0], root.val+ left + right);

        return root.val + Math.max(left,right);
    }

    public int maxPathSum2(TreeNode root) {
        dfs(root);

        return max;
    }


    public int getMax(TreeNode root) {
        if(root==null) return 0;

        int left = getMax(root.left);
        int right = getMax(root.right);

        int path = root.val + Math.max(left,right);
        return Math.max(0,path);

    }

    public void dfs(TreeNode root) {
        if(root==null) return;
        int left = getMax(root.left);
        int right = getMax(root.right);
        max = Math.max(max, root.val + left + right);

        dfs(root.left);
        dfs(root.right);

    }
}
