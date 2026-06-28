class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums,0,new ArrayList<>(),result);

        return result;
    }

    public void helper(int[] nums,int index,List<Integer> temp,List<List<Integer>> result) {

        for(int i=index;i<nums.length;i++) {
            temp.add(nums[i]);
            helper(nums,i+1,temp,result);
            temp.remove(temp.size()-1);
        }
        result.add(new ArrayList<>(temp));

    }
}
