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
    int count;
    public int equalToDescendants1(TreeNode root) {
        count=0;
        if(root==null) return count;
        //sub tree sum will go up to root and check if its equal to root
        //base cond => if(root ==null) return 0;
        //if (root == left + right) count+1;
        // return root+left+right;
        
        helper(root);

        return count;
    }


    public long helper(TreeNode root) {
        if(root==null) return 0;

        long left = helper(root.left);
        long right = helper(root.right);
        if(root.val == left+right) {
            count+=1;
        }

        return root.val+left+right;
    }


    public int equalToDescendants(TreeNode root) {
        int count = 0;

        if(root==null) return count;

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        for(int i=0;i<nodes.size();i++) {
            TreeNode node = nodes.get(i);

            if(node.left!=null) {
                nodes.add(node.left);
            }

            if(node.right!=null) {
                nodes.add(node.right);
            }

        }

        Map<TreeNode,Long> subTrees= new IdentityHashMap<>();

         for (int i = nodes.size() - 1; i >= 0; i--) {
            TreeNode node = nodes.get(i);

            long leftSum = subTrees.getOrDefault(node.left,0L);
            long rightSum = subTrees.getOrDefault(node.right,0L);

            long descendantSum = leftSum + rightSum;

            if(node.val == descendantSum) count++;

            subTrees.put(node, descendantSum + node.val);
         }



        return count;
    }
}
