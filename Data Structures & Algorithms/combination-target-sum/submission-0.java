class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,target,0,new ArrayList<>(),result);
        return result;
    }

    public void helper(int[] nums,int target, int index, List<Integer> temp, List<List<Integer>> result) {
        if(target==0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<nums.length;i++) {
            //this will like for the same numbers
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(target>=nums[i]) {
                temp.add(nums[i]);
                helper(nums,target-nums[i],i,temp,result);
                temp.remove(temp.size()-1);
            }
        }
    }
}
