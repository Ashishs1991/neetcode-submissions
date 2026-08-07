class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Node> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            int start = i;

            // Pop all taller bars
            while (!stack.isEmpty() && stack.peek().h > heights[i]) {
                Node node = stack.pop();

                int area = node.h * (i - node.index);
                max = Math.max(max, area);

                // Current shorter bar can extend from here
                start = node.index;
            }

            // Only push if different height (optional optimization)
            if (stack.isEmpty() || stack.peek().h < heights[i]) {
                stack.push(new Node(start, heights[i]));
            }
        }

        // Remaining bars extend till the end
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int area = node.h * (heights.length - node.index);
            max = Math.max(max, area);
        }

        return max;
    }
}

class Node {
    int index;
    int h;

    Node(int index, int h) {
        this.index = index;
        this.h = h;
    }
}