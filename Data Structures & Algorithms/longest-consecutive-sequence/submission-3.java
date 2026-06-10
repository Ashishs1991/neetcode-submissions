class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        if(nums.length<2) return nums.length;

        for(int i:nums) {
            set.add(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            int current = nums[i];
            int tempCount = 0;
            while(set.contains(current)) {
                tempCount+=1;
                max = Math.max(max,tempCount);
                current = current+1;
            }
        }
        
        return max;
    }
}
