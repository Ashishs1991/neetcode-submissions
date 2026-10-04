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
class Node {
    int maxSize;
    int maxNode;
    int minNode;

    Node (int maxSize,int maxNode,int minNode) {
        this.maxSize=maxSize;
        this.maxNode = maxNode;
        this.minNode = minNode;
    }
}
class Solution {


    public Node helper(TreeNode root) {
        if(root==null) return new Node(0,Integer.MIN_VALUE,Integer.MAX_VALUE);

        Node left = helper(root.left);
        Node right = helper(root.right);

        if(left.maxNode < root.val && root.val < right.minNode) {
            //this is a BST;
            int maxSize = left.maxSize + right.maxSize+1;
            int maxNode = Math.max(root.val,right.maxNode);
            int minNode = Math.min(root.val,left.minNode);
            return new Node(maxSize,maxNode,minNode);
        }

        return new Node(Math.max(left.maxSize, right.maxSize),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    public int largestBSTSubtree(TreeNode root) {
        return helper(root).maxSize; 
    }
}
