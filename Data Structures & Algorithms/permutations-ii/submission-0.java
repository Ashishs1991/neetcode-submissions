class Solution {
    
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] freq = new boolean[nums.length];
        helper(nums,0,new ArrayList<>(),freq);
        return result;
    }

    public void helper(int[] nums,int index,List<Integer> temp,boolean[] freq) {
        if(temp.size()==nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !freq[i - 1]) {
                continue;
            }
            if(!freq[i]) {
                freq[i] = true;
                temp.add(nums[i]);
                helper(nums,index+1,temp,freq);
                freq[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}