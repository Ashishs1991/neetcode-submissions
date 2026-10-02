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

    // we created this result where the index is the heaigh at which we are adding the leaves
    List<List<Integer>> result;

    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        getHeight(root);
        return result;        
    }


    public int getHeight(TreeNode node) {
        if(node == null) return -1;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        int currentHeight = Math.max(left,right) +1;
        
        if(currentHeight == result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(currentHeight).add(node.val);
        return currentHeight;
        
    }
}
