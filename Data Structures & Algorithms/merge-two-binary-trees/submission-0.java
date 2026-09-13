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

         //if root1.left ==null && root2.left!=null
        //if root1.left !=null && root2.left==null
        ////if root1.left !=null && root2.left!=null // sum together


        //if root1.right ==null && root2.right!=null
        //if root1.right !=null && root2.right==null
        ////if root1.right !=null && root2.right!=null // sum together
class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        

        if (root1 == null) return root2;
        if (root2 == null) return root1;


        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);

        return root1;
    }
}