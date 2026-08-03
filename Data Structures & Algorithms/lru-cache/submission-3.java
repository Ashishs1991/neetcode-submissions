class LRUCache {
    int capacity;
    HashMap<Integer,Node> cache;
    Node right;
    Node left;

    public LRUCache(int capacity) {
        this.capacity= capacity;
        cache = new HashMap<>();
        this.right = new Node(0,0);
        this.left = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = this.right.prev;
        prev.next= node;
        node.prev= prev;
        node.next = this.right;
        this.right.prev= node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            
            //why we are removing this
            remove(node);
            // why we are inserting 
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node newNode = new Node (key,value);
        cache.put(key,newNode);
        insert(newNode);

        if(cache.size()>capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;

    public Node (int key,int val) {
        this.val=val;
        this.key = key;
        this.next=null;
        this.prev = null;
    }
}