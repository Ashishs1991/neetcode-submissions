class Node {
    int neighbor;
    int time;

    Node(int neighbor,int time) {
        this.neighbor = neighbor;
        this.time = time;
    }
}
//Dijkstra Problem


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Adj list;
        ArrayList<Node>[] adj = new ArrayList[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.time,b.time));

        for(int i=0;i<=n;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] time: times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj[u].add(new Node(v,t));
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;
        pq.offer(new Node(k,0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.neighbor;
            int t = node.time;

            if(t>distance[u]) continue;

            for(Node edge: adj[u]) {
                int newT = t+edge.time;
                int newU = edge.neighbor;
                if(newT < distance[newU]) {
                    distance[newU] = newT;
                    pq.offer(new Node(newU,newT));
                }
            }
        }

        int answer = 0;
        for(int i =1;i<=n;i++) {
            if(distance[i]==Integer.MAX_VALUE) return -1;
            answer = Math.max(answer,distance[i]);
            
        }

        return answer;
    }
}
