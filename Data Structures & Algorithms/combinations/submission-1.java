class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n,k,1,new ArrayList<>(),new int[1]);    
        return result;
    }

    public void helper(int n,int k,int index, List<Integer> temp,int[] arr) {
        if(arr[0]==k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<=n;i++) {
            temp.add(i);
            arr[0]+=1;
            helper(n,k,i+1,temp,arr);
            temp.remove(temp.size()-1);
            arr[0]-=1;
        }

    }
}