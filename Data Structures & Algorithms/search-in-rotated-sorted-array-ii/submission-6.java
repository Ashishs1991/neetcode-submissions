class Solution {
    public boolean search(int[] nums, int target) {

        int l =0;
        int r = nums.length-1;

        //simeple binary search;

        while(l<=r) {
            int mid = l +(r-l)/2;

            if(nums[mid]==target) {
                return true;
            }

            // Duplicates prevent us from identifying the sorted side.
            if(nums[l]== nums[mid] && nums[mid]==nums[r]) {
                l++;
                r--;
            }//checking if left side is sorted 
            else if (nums[l] <= nums[mid]) {
                if(nums[l]<=target && nums[mid]>target) {
                    r= mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                //right side is sorted
                if(nums[r]>=target && nums[mid]<target) {
                   l = mid+1;
                }else {
                    r = mid-1;
                }
            }
        }
         return false;
    }
}