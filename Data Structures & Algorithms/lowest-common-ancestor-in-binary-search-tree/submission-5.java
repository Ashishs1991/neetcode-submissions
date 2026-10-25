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
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        boolean[] found = postOrder(root,p,q);
        return lca;        
    }

    public boolean[] postOrder(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return new boolean[2];
        }

        boolean[] left = postOrder(root.left,p,q);
        boolean[] right= postOrder(root.right,p,q);

        boolean foundP = left[0] || right[0] || root==p;
        boolean foundQ = left[1] || right[1] || root==q;

        if(lca==null && foundP && foundQ) {
            lca = root;
        }
        return new boolean[]{foundP,foundQ};
    }
}
