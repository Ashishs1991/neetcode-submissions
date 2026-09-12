class Solution {
    //This is the topological Sorted order we require
    boolean[] visited;
    Stack<Integer> st;
    boolean[] path;
    public int[] findOrder(int numCourses, int[][] preqs) {

        List<Integer>[] adj = new ArrayList[numCourses];

        visited = new boolean[numCourses];
        st= new Stack<>();
        path= new boolean[numCourses];

        for(int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] preq: preqs) {
            int a = preq[1];
            int b = preq[0];
            adj[a].add(b);
        }

        for(int i=0;i<numCourses;i++) {
            if(!visited[i]) {
                //there is no cycle
                if(dfs(adj,i)) {
                    return new int[0];
                }
            }
        }
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            result[i] = st.pop();
        }

        return result;
    }

    public boolean dfs( List<Integer>[] adj,int i) {
        visited[i] = true;
        path[i] = true;
        

        for(int course: adj[i]){
            if(!visited[course]) {
                if(dfs(adj,course)) {
                    return true;
                }
            }else if (path[course]) {
                return true;
            }
        }
        st.push(i);
        path[i] = false;
        return false;
    }
}
