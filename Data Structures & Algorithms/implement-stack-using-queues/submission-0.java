class Node implements Comparable<Node>{
    int x;
    int index;

    Node(int x,int index) {
        this.x = x;
        this.index=index;
    }

    public int compareTo(Node n) {
        return n.index-this.index;
    }
}
class MyStack {
    PriorityQueue<Node> pq ;
    int index;
    public MyStack() {
        pq = new PriorityQueue<>();
        index=0;
    }
    
    public void push(int x) {
        pq.offer(new Node(x,index++));
    }
    
    public int pop() {
        if(!empty()){
            int x = pq.remove().x;
            index--;
            return x;
        }
        return 0;
    }
    
    public int top() {
        if(!empty()) {
            return pq.peek().x;
        }
        return 0;
    }
    
    public boolean empty() {
        return pq.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */