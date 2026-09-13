/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {

    List<Integer> result;
    public List<Integer> postorder(Node root) {
        result = new ArrayList<>();
        postorder1(root);
        return result;        
    }

    public void postorder1(Node node) {
        if(node==null) return;

        for(Node n: node.children) {
            postorder1(n);
        }
        result.add(node.val);
    }
}