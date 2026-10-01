class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();

        if (root == null) {
            return boundary;
        }

        // Root is always added exactly once.
        boundary.add(root.val);

        addLeftBoundary(root.left, boundary);
        addLeaves(root.left, boundary);
        addLeaves(root.right, boundary);
        addRightBoundary(root.right, boundary);

        return boundary;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(
        TreeNode node,
        List<Integer> boundary
    ) {
        TreeNode current = node;

        while (current != null) {
            // Leaves will be added separately.
            if (!isLeaf(current)) {
                boundary.add(current.val);
            }

            // Stay as far left as possible.
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    private void addLeaves(
        TreeNode node,
        List<Integer> boundary
    ) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            boundary.add(node.val);
            return;
        }

        // Left-first DFS gives left-to-right leaf order.
        addLeaves(node.left, boundary);
        addLeaves(node.right, boundary);
    }

    private void addRightBoundary(
        TreeNode node,
        List<Integer> boundary
    ) {
        List<Integer> rightBoundary = new ArrayList<>();
        TreeNode current = node;

        while (current != null) {
            // Leaves will be added separately.
            if (!isLeaf(current)) {
                rightBoundary.add(current.val);
            }

            // Stay as far right as possible.
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        // Right boundary must be added bottom-up.
        for (int i = rightBoundary.size() - 1; i >= 0; i--) {
            boundary.add(rightBoundary.get(i));
        }
    }
}