class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][2];
        return helper(prices,0,0,memo);
    }

    public int helper(int[] prices,int index,int sell,Integer[][] memo) {

        if(index>=prices.length) return 0;
        if(memo[index][sell]!=null) return memo[index][sell];

        int profit = helper(prices,index+1,sell,memo);

        if(sell==1) {
            profit = Math.max(profit,prices[index]+ helper(prices,index+1,0,memo));
        }else {
            profit = Math.max(profit,-prices[index]+ helper(prices,index+1,1,memo));
        }

        return memo[index][sell] = profit;
    }
}