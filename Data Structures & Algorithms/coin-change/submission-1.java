class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount+1];
        int ans = helper(coins, amount,memo);

        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    public int helper(int[] coins,int target,Integer[] memo) {
        if(target==0) {
            return 0;
        }

        if(memo[target]!=null) return memo[target];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++) {
            if(coins[i]<=target) {
                int res = helper(coins,target-coins[i],memo);
                if(res != Integer.MAX_VALUE) {
                    min = Math.min(min,1+res);
                }
            }
        }

        return memo[target]=min;
    }
}
