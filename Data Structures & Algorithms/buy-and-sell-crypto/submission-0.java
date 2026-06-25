class Solution {
    public int maxProfit(int[] nums) {

        if(nums.length==1) return 0;

        int min = nums[0];
        int minIndex = 0;
        int profit=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<=min) {
                min = nums[i];
                minIndex=i;
            }else {
                profit = Math.max(profit, (nums[i]-min));
            }
        }


        return profit;
        
    }
}
