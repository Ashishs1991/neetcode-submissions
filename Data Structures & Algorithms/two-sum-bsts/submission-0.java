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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> map1 = new HashSet<>();
        HashSet<Integer> map2 = new HashSet<>();

        fillMap(map1,root1);
        fillMap(map2,root2);
        return hasSum(map1,map2,target);
    }

    public void fillMap(HashSet<Integer> map1,TreeNode root) {
        if(root==null) return;

        fillMap(map1,root.left);
        fillMap(map1,root.right);
        if(root!=null) map1.add(root.val);
    }

    public boolean hasSum(HashSet<Integer> map1,HashSet<Integer> map2,int target) {

        for(int k : map1) {
            int a = target-k;
            if(map2.contains(a)) return true;
        }

        return false;

    }
}
