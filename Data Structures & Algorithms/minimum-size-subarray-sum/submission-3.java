class Solution {
    public int minSubArrayLen(int target, int[] nums) {
         int left = 0;
         int total = 0;

         for(int i: nums) {
            total+=i;
         }

         if(target>total) return 0;
         if(target==total) return nums.length;
         int min = nums.length+1;
         int sum=0;
         for(int right =0;right<nums.length;right++) {
            sum+=nums[right];
            while(sum>=target) {
                min = Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
         }

         return min;
    }
}