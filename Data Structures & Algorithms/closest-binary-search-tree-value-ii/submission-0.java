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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>((a,b) -> Double.compare(a.getValue(),b.getValue()));
        helper(root,pq,target);

        List<Integer> result = new ArrayList<>();

        while(k>0) {
            result.add(pq.poll().getKey());
            k--;
        }
        
        return result;
    }

    public void helper(TreeNode node,PriorityQueue<Pair<Integer,Double>> pq,double target) {
        if(node==null) return;

        helper(node.left,pq,target);
        helper(node.right,pq,target);
        pq.offer(new Pair(node.val,Math.abs(node.val-target)));
    } 
}
