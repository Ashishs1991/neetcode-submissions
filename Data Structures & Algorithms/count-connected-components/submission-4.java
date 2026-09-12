class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
            adj = new ArrayList[n];

            for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            adj[a].add(b);
            adj[b].add(a);

        }

        visited = new boolean[n];
         
        int count = 0;

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }


        return count;
    }


    public void dfs(int i) {
        visited[i]=true;

        for(int node: adj[i]) {
            if(!visited[node]) {
                dfs(node);
            }
        }

    }
}
