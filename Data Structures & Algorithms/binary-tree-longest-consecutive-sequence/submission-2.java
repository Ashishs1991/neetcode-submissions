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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        preOrder(root,null,0);
        return max;

    }

    public void preOrder(TreeNode node,TreeNode parent,int length) {
        if(node==null) return;
        
        // if(parent!=null && parent.val + 1 == node.val) {
        //     length = length+1;
        // }else{
        //     length = 1;
        // }
        length = (parent != null && node.val == parent.val + 1) ? length + 1 : 1;

        max = Math.max(max,length);

        preOrder(node.left,node,length);
        preOrder(node.right,node,length);
    }
}
