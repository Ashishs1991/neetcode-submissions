class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n,k,1,new ArrayList<>(),result);
        return result;
    }

    public void helper(int n, int k,int index,List<Integer> temp,List<List<Integer>> result) {
        if(k==0) {
            result.add(new ArrayList<>(temp));
        }

        for(int i=index;i<=n;i++) {
            temp.add(i);
            k--;
            helper(n,k,i+1,temp,result);
            temp.remove(temp.size()-1);
            k++;
        }
    }
}