class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        //email -> index of acc
        Map<String,Integer> emailToAcc = new HashMap<>();

        //build Union Find Struct

        for(int i=0;i<n;i++) {
            List<String> account = accounts.get(i); //  ["neet","neet@gmail.com","neet_dsa@gmail.com"]

            for(int j=1;j<account.size();j++) {
                String email = account.get(j);
                if(emailToAcc.containsKey(email)) {
                    uf.union(i,emailToAcc.get(email));
                }else {
                    emailToAcc.put(email,i);
                }
            }
        }

        // group Emails by leader here the index is the names;
        Map<Integer, List<String>> emailGroup = new HashMap<>();

        for(Map.Entry<String,Integer> entry : emailToAcc.entrySet()) {
            String email = entry.getKey(); // this will give you email 
            int accId = entry.getValue();

            int leader = uf.find(accId);

            emailGroup.putIfAbsent(leader,new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

         // Build result
        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<Integer,List<String>> entry : emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            //since we need emails to be sorted 
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0)); // name of the person is stored in the first element of the list;
            merged.addAll(emails);
            res.add(merged);
        }


        return res;
    }
}

class UnionFind {
    // this is like the parent of the group
    int[] parent;

    //like the rank of the people ion the group so that youknow who to meger to who
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //As the name suggest there are 2 functions
    //Find the parent; this do normal DFS to find the parent
    public int find(int x) {
        if(x!=parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // we have to check if x1 and x2 are in a union
    public boolean union(int x1 ,int x2) {
        int p1 = find(x1);
        int p2 = find(x2);

        if(p1==p2) {
            return false;
        }else if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }else {
            parent[p1] = p2;
            //check with gpt why we are increasing the rank of the larger parennt
            rank[p2]+= rank[p1];
        }

        return true;
    }
}