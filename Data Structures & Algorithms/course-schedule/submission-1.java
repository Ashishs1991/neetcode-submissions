class Solution {
    boolean[] visited;
    boolean[] path;
    public boolean canFinish(int numCourses, int[][] preqs) {
        visited = new boolean[numCourses];
        path = new boolean[numCourses];

        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<>();
        }

        //graph list
        for(int[] preq : preqs) {
            int a = preq[1];
            int b = preq[0];

            adj[a].add(b);
        }

        for(int i=0;i<numCourses;i++) {
            if(!visited[i]) {
                if(dfs(i,adj)) {
                    return false;
                }
            }
        }

        return true;
    }

    //if true it has cycle if false it has no cycle
    public boolean dfs(int i, List<Integer>[] adj) {
        visited[i] = true;
        path[i] = true;

        for(int course: adj[i]) {

            if(!visited[course]) {
                if(dfs(course,adj)) {
                    return true;
                }
            }else if(path[course]) {
                    return true;
            }
        }

        path[i] = false;;
        return false;
    }
}
