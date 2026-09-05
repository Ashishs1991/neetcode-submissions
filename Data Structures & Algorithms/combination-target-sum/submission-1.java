class Solution {
 
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums,target,0,new ArrayList<>());
        return result;    
    }

    public void helper(int[] nums,int target,int index,List<Integer> temp) {
        //base condition
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i= index;i<nums.length;i++) {
            if(nums[i]<=target) {
                temp.add(nums[i]);
                helper(nums,target-nums[i],i,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
