class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        //level order traversal
        if(root==u) return null;
        
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++) {
                TreeNode node = q.poll();
                if(node==u) {
                    // if(q.isEmpty()) {
                    //     return null;
                    // }else {
                    //     return q.poll();
                    // }
                     return i + 1 < levelSize ? q.peek() : null;
                }
                if(node.left!=null) {
                    q.offer(node.left);
                }

                if(node.right!=null) {
                    q.offer(node.right);
                }
            }
        }

        return null;
    }
}
