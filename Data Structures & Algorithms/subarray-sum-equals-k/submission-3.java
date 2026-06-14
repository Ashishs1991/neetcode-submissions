class Solution {
    public int subarraySum(int[] nums, int k) { 

        HashMap<Integer,Integer> preFixSumMap = new HashMap<>();

        //This is basically a prefixSum of 0 which is there.
        preFixSumMap.put(0,1);

        int totalSum=0;
        int result=0;
        for(int i=0;i<nums.length;i++) {
            totalSum+=nums[i];
            int diff = totalSum-k;
            result += preFixSumMap.getOrDefault(diff,0);
            preFixSumMap.put(totalSum, preFixSumMap.getOrDefault(totalSum,0)+1);
        }
        
        return result;
    }
}