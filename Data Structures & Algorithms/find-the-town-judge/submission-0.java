class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = buildAdjList(n, trust);
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++) {
            
            for(int b: adj.get(i)) {
                arr[b]+=1;
            }
        }
        // System.out.println(Arrays.toString(arr));

        int index =0;
        for(int i=1;i<=n;i++) {
            if(arr[i]==n-1) {
                index= i;
                break;
            }
        }

        if(index!=0 && adj.get(index).size()==0) return index;
        return -1;        
    }



    public List<List<Integer>> buildAdjList(int n, int[][] trust) {
         List<List<Integer>> adj = new ArrayList<>();

         for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
         }

         for(int[] t: trust) {
            int a = t[0];
            int b = t[1];

            //a->b
            adj.get(a).add(b);
         }

         return adj;
    }
}