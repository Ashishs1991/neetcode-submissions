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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        pre(p,l1);
        pre(q,l2);
        return compare(l1,l2);
    }

    public void pre(TreeNode node, List<Integer> l) {
        if(node==null) {
            l.add(null); 
            return;
        }

        l.add(node.val);
        pre(node.left,l);
        pre(node.right,l);
    }

    public boolean compare(List<Integer> l1,List<Integer> l2) {
        if(l1.size()!=l2.size()) return false;

        for(int i=0;i<l1.size();i++) {
            if(l1.get(i)!=l2.get(i)){
                return false;
            }
        }

        return true;
    }
}
