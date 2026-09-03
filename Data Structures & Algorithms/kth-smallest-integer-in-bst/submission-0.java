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
    
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> (a-b));
        dfs(root,q);

        while(k>1) {
            q.poll();
            k--;
        }

        return q.peek();
    }

    public void dfs(TreeNode node, PriorityQueue<Integer> q) {
        if(node == null) return;


        q.add(node.val);
        dfs(node.left,q);
        dfs(node.right,q);
    }
}
