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
    double max = 0.0;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);

        return max;       
    }

    public double[] dfs(TreeNode root) {
        if(root==null) return new double[]{0,0};

        double[] left = dfs(root.left);
        double[] right = dfs(root.right);

        double sum = root.val + left[0] + right[0];
        double count = 1 + left[1] + right[1];

        double avg = sum/count;

        max = Math.max(max, avg);
        return new double[]{sum,count};
    }
}
