class Solution {
    public int search(int[] nums, int target) {
        int r = nums.length-1;
        int l =0;

        
        while(l<r) {
            int mid = l + (r-l)/2;

            if(nums[mid] < nums[r]) {
                r = mid;
            }else {
                l = mid+1;
            }
        }

        int pivot = l;
        
        //Once you find the pivot you have to search from 0 -> pivot -1;
        int result = binarySearch(nums,target,0,pivot-1);

        if(result!=-1) return result;

        //search the second half;
        return binarySearch(nums,target,pivot,nums.length-1);
    }

    public int binarySearch(int[] nums, int target,int l,int r) {
        while(l<=r) {
            int mid = l+(r-l)/2;

            if(nums[mid]<target) {
                l = mid+1;
            }else if(nums[mid]>target) {
                r = mid-1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
