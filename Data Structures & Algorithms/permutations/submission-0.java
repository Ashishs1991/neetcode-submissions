class Solution {
    
    
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] freq = new boolean[nums.length];

        helper(nums,freq,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums,boolean[] freq,List<Integer> temp) {
        if(temp.size()==nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!freq[i]) {
                freq[i] = true;
                temp.add(nums[i]);
                helper(nums,freq,temp);
                temp.remove(temp.size()-1);
                freq[i] = false;
            }
        }
    }
}
