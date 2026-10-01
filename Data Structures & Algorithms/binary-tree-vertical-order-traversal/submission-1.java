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
    /*
    Root node column 0 if we go left 
    if we go left -1 
    if we go right we do +1
    For this we have to keep a track of a column variable
    And we have to make a either an HashMap we map wioth coumn and number
    **/
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, 0));

        while(!queue.isEmpty()) {
            Pair<TreeNode,Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int col = p.getValue();

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if(node.left!=null) queue.offer(new Pair<>(node.left,col-1));
            if(node.right!=null) queue.offer(new Pair<>(node.right,col+1));
        }

        return new ArrayList<>(map.values());
    }
}

