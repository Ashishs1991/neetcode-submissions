/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // wehave to see in the on left or right or root node all the
        //p and q are visible
        lca=null;
        boolean[] found = postOrder(root,p,q);
        return found[0] && found[1] ? lca : null;
        
    }

    public boolean[] postOrder(TreeNode root,TreeNode p,TreeNode q) {
        if(root==null) {
            return new boolean[2];
        }

        boolean[] left = postOrder(root.left,p,q);
        boolean[] right = postOrder(root.right,p,q);

        boolean foundP = left[0] || right[0] || root==p;
        boolean foundQ = left[1] || right[1] || root==q;

        if(lca==null && foundP && foundQ) lca = root;
        
        return new boolean[]{foundP,foundQ};
    }
}
