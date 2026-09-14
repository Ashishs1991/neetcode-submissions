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
public class Solution {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        map = new HashMap<>();
        map.put(null, 0);
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(map.containsKey(root)) return map.get(root);

        int res = root.val;
        if (root.left != null) {
            res += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            res += dfs(root.right.left) + dfs(root.right.right);
        }

        res = Math.max(res, dfs(root.left) + dfs(root.right));
        map.put(root,res);
        return res;
    }
}