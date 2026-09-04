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

    public boolean isLeaf(TreeNode node) {
        if(node.left==null && node.right ==null) {
            return true;
        }

        return false;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;

        //
        root.left = removeLeafNodes(root.left,target); // 5
        root.right = removeLeafNodes(root.right,target); // 2

        //leaf node
        if(isLeaf(root) && root.val==target) {
            return null;
        }


        return root;
        
    }
}