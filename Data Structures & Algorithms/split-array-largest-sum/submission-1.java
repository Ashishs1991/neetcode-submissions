class Solution {
    public int splitArray(int[] nums, int k) {
        int l =0;
        int r =0;
        int res =0;

        for(int i :nums) {
            l = Math.max(l,i);
            r +=i;
        }

        res = r;

        while(l<=r) {
            int mid = l + (r-l)/2;
            if(canSplit(nums,k,mid)) {
                res = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        
        return res;
    }

    public boolean canSplit(int[] nums,int k,int largest) {
        int subarray =1, curSum =0;

        for(int i: nums) {
            curSum+=i;
            if(curSum> largest) {
                subarray++;
                if(subarray > k) return false;
                curSum = i;
            }
        }

        return true;
    }
}