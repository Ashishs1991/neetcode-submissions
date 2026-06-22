class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) return 0;
        int left =1;
        

        for(int right =1; right<n;right++) {
            if(nums[right]!=nums[right-1]) {
                nums[left] =nums[right];
                left++;
            }
        }

        return left;  
    }
}