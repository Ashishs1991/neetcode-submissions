class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        HashSet<TreeNode> setNode = new HashSet<>();

        for(TreeNode node: nodes) {
            setNode.add(node);
        }


        //we do DFS and found the values
        return dfs(root,setNode);
    }

    public TreeNode dfs(TreeNode root,HashSet<TreeNode> set) {
        if(root==null || set.contains(root)){
            return root;
        }

        TreeNode left = dfs(root.left,set);
        TreeNode right = dfs(root.right,set);

        //Requested Node exsist on both side
        if(left!=null && right!=null) {
            return root;
        }

        return left!=null ? left : right;
    }
}
