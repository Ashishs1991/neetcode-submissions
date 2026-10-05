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

    
    /**
    So we look for the largest heigh on ever
    node every node largest heigh is sum o
    
    
    */
    int dia;
    public int diameter(Node root) {
        this.dia = 0;
        height(root);
        return dia;
    }

    public int height(Node node) {
        // base case u are at the leaf node 
        if(node.children.size()==0) return 0;

        int maxHeight1=0, maxHeight2=0;

        for(Node child: node.children) {
            int parentHeight = height(child)+1;

            if(parentHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight; 
            }else {
                maxHeight2 = parentHeight;
            }

            int distance = maxHeight1 + maxHeight2;
            this.dia = Math.max(this.dia,distance);
        }

        return maxHeight1;
    }
}
