class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        this.next =null;
    }
}
class MyCircularQueue {
    int space;
    Node left;
    Node right;
    public MyCircularQueue(int k) {
        this.space = k;
        this.left = new Node(0);
        this.right = this.left;
    }
    
    public boolean enQueue(int value) {
        //if its the first element
        if (isFull()) return false;
        Node currentNode = new Node(value);

        if(isEmpty()) {
            this.left.next = currentNode;
            this.right = currentNode;
        }else {
            this.right.next = currentNode;
            this.right = currentNode;
        }

        this.space--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        // why is this because we will doing FIFO 
        /**
        so basicalli we will be removing the first elemnet 
        refrencing the old first element next and makinfg it
        the first or the left most        
        */

        this.left.next = this.left.next.next;
        if(this.left.next==null) {
            this.right = this.left;
        }  

        this.space++;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1: this.left.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1: this.right.val;
    }
    
    public boolean isEmpty() {
        return this.left.next==null;
    }
    
    public boolean isFull() {
        return this.space==0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */