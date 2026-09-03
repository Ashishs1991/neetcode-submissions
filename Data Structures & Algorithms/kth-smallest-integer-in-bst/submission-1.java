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

        int[] count = new int[2];

        count[0] =k;

        dfs2(root,count);

        return count[1];
    }

    public void dfs2(TreeNode node,int[] count) {
        if(node==null) return;

        dfs2(node.left,count);
        if(count[0]==0) return;
        count[0]-=1;
        if(count[0]==0) {
            count[1] = node.val;
            return;
        }
        dfs2(node.right,count); 

    }


    public int kthSmallest1(TreeNode root, int k) {
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
