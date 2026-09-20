class Solution {
    int N;
    public int minCostClimbingStairs(int[] cost) {
        // you can start from 0 or 1 ;
        N= cost.length;
        return Math.min(helper(cost,0,new Integer[N]), helper(cost,1,new Integer[N]));
    }

    public int helper(int[] cost,int start,Integer[] memo) {
        if(start>=N) return 0;
        if(start==N-1) return cost[N-1];

        if(memo[start]!=null) return memo[start];

        return memo[start]= cost[start] + Math.min(helper(cost,start+1,memo),helper(cost, start+2,memo));
    }
}
