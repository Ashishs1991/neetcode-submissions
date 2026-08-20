class Solution {
    public int search(int[] nums, int target) {



        int l =0;
        int r = nums.length-1;

        if(r+1==1) return nums[0]==target ? 0 : -1;

        while(l<=r) {
            int middle = l+(r-l)/2;
            if(nums[middle]>target) {
                r = middle-1;
            }else if(nums[middle]<target) {
                l = middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
