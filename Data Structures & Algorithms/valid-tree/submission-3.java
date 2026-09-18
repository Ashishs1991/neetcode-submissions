class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    public boolean validTree(int n, int[][] edges) {
        adj = new ArrayList[n];
        visited = new boolean[n];

        for(int i =0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            int a= edge[0];
            int b= edge[1];

            //this is undirected so we need to add both
            adj[a].add(b);
            adj[b].add(a);
        }

        //to be a tree
        /** we should not have any cycle
        we should not have any disconnected component 
        */

        if(dfs(0,-1)) {
            return false;
        }

        if(allNotVisited()) return false;

        return true;
    }

    public boolean allNotVisited() {
        for(boolean vis : visited) {
            if(!vis) return true;
        }

        return false;
    }
    
    //code to detect cycle
    public boolean dfs(int start,int parent) {
        visited[start] = true;

        for(int nei: adj[start]) {
            if(nei == parent) continue;

            //there is a cycle here
            if(visited[nei]) return true;

            if(dfs(nei,start)) return true;
        }
        return false;
    }

    
}
