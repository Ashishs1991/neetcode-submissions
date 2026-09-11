class KthLargest {

    PriorityQueue<Integer> pq;
    int kLargest;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a,b) -> (a-b));
        for(int i: nums) {
            pq.offer(i);

            if(pq.size()>k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k) {
            pq.poll();
        }

        return pq.peek();
    }
}
