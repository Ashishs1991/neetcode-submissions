class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;

        int left =0;
        int right =n-1;
        int max = Integer.MIN_VALUE;


        while(left<right) {
            int vol=0;

            int height = nums[left]>nums[right] ? nums[right] : nums[left];
            int length = right-left;

            max = Math.max(max,(height*length));

            if(nums[left]>nums[right]) {
                right--;
            }else if (nums[left]<nums[right]) {
                left++;
            }else {
                left++;
                right--;
            }
        }
        

        return max;
    }
}
