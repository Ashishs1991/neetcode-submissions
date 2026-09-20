class Solution {
    Integer[][] memo;
    public int rob(int[] nums) {
        memo = new Integer[nums.length][2];
        return Math.max(helper(nums,0,0),helper(nums,1,0));
    }

    public int helper (int[] nums,int start, int canRob) {
        //Base case

        if(start>=nums.length) return 0;
        /*
        Two cases 
        - I can Rob
        - I can skip        
        **/

        if(memo[start][canRob]!=null) return memo[start][canRob];
        //skip case
        int skipRobbing = helper(nums,start+1,0);

        //rob
        int robbing =0;
        if(canRob==0) {
            robbing = nums[start] + helper(nums,start+1,1);
        }

        return memo[start][canRob] = Math.max(skipRobbing,robbing);
    }
}
