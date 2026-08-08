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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();


        pre(root,l1);
        pre(subRoot,l2);

        return compare(l1,l2);

    }


    public void pre(TreeNode root,List<Integer> l1) {
        if(root==null) {
            l1.add(null);
            return;
        }

        l1.add(root.val);
        pre(root.left,l1);
        pre(root.right,l1);
    }

    public boolean compare(List<Integer> l1, List<Integer> l2) {

    if (l2.size() > l1.size())
        return false;

    for (int i = 0; i <= l1.size() - l2.size(); i++) {

        boolean match = true;

        for (int j = 0; j < l2.size(); j++) {

            if (!Objects.equals(l1.get(i + j), l2.get(j))) {
                match = false;
                break;
            }
        }

        if (match)
            return true;
    }

    return false;
}
}
