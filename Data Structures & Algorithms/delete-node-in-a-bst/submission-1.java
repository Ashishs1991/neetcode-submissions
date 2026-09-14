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

 //root = right;
 //
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        else if (root.val>key) root.left = deleteNode(root.left,key);
        else if (root.val<key) root.right = deleteNode(root.right,key);
        // we found the key
        else {
            if(root.left==null && root.right ==null) {
                return null;
            }else if(root.left==null) {
                return root.right;
            }else if(root.right==null) {
                return root.left;
            }else { // we have 2 children of the node whihc we are removing
                // now we have to find the successor or tha delete node
                TreeNode suc = getSuc(root.right);
                root.val = suc.val;
                root.right = deleteNode(root.right,suc.val);
            }
        }

        return root;
    }

    public TreeNode getSuc(TreeNode node) {
        // now we have to go top the smallest on the right side 
        while(node!=null && node.left!=null) {
            node = node.left;
        }

        return node;
    }
}