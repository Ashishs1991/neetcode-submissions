class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n,k,1,new ArrayList<>());    
        return result;
    }

    public void helper(int n,int k,int index, List<Integer> temp) {
        if(temp.size()==k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<=n;i++) {
            temp.add(i);
            helper(n,k,i+1,temp);
            temp.remove(temp.size()-1);
      
        }

    }
}