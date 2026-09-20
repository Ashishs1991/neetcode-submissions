class Solution {
    public int maxProduct(int[] nums) {

        /*
        We need to keep track of start and end       
        **/

        int res = nums[0];

        int curMax = 1;
        int curMin = 1;

        for(int num: nums) {
            int temp = curMax * num;
            curMax = Math.max(Math.max(num*curMax,num*curMin),num);
            curMin = Math.min(Math.min(temp,num*curMin),num);
            res = Math.max(res,curMax);
        }
        
        return res;
    }
}
