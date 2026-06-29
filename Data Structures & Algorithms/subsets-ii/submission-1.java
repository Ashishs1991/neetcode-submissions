class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>());
        return result;
    }

    public void helper (int[] nums,int index,List<Integer> temp) {

        for(int i=index;i<nums.length;i++) {
            if(i>index && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            helper(nums,i+1,temp);
            temp.remove(temp.size()-1);
        }

        result.add(new ArrayList<>(temp));

    }
}
