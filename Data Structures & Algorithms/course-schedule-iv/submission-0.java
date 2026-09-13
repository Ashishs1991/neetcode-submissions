class Solution {
    List<Integer>[] adj;
    Map<Integer,Set<Integer>> preMap;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList[numCourses];

        preMap = new HashMap<>();
        for(int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            adj[a].add(b);
        }

        for(int i=0;i<numCourses;i++) {
            dfs(i);
        }

        List<Boolean> result = new ArrayList<>();

        for(int[] query: queries) {
            result.add(preMap.get(query[0]).contains(query[1]));
        }

        return result;
    }


    public Set<Integer> dfs(int start) {
        if(preMap.containsKey(start)) return preMap.get(start);
        Set<Integer> prereqs = new HashSet<>();
        for(int i: adj[start]) {
            prereqs.addAll(dfs(i));
        }

        prereqs.add(start);
        preMap.put(start,prereqs);
        return prereqs;
    }
}