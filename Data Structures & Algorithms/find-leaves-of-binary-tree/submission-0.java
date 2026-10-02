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
    List<List<Integer>> result;
    public int getHeight(TreeNode root) {
        if(root==null) {
            return -1;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int currentHeight = Math.max(left,right)+1;
        if(currentHeight == result.size()) {
            this.result.add(new ArrayList<>());
        }

        result.get(currentHeight).add(root.val);
        return currentHeight;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        getHeight(root);
        return result;        
    }
}
