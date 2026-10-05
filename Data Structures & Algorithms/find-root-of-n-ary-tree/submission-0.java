/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        HashSet<Integer> set = new HashSet<>();

        //first we added all the valuies in the set
        for(Node node: tree) {
            for(Node c: node.children) {
                set.add(c.val);
            }
        }

        //since root is. not child of any one so any value which
        // is not in the set is the root
        Node root = null;

        for(Node node: tree) {
            if(!set.contains(node.val)) {
                root = node;
                break;
            }
        }
        
        return root;
    }
}
