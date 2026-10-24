class Solution {
    public long maximumSumScore(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        long[] prefix = new long[n];
        long[] suffix = new long[n];

        //build the prefix
        for(int i =0;i<n;i++) {
            if(i==0) {
                prefix[i] = (long) (nums[i]);
                continue;
            }
            prefix[i] = prefix[i-1]+(long)(nums[i]); 
        }

        // System.out.println(Arrays.toString(prefix));

        // build suffix
        
        for(int i=n-1;i>=0;i--) {
            if(i==n-1) {
                suffix[i] = nums[i];
                continue;
            }
            suffix[i] = suffix[i+1]+nums[i]; 
        }
        // System.out.println(Arrays.toString(suffix));

        long max = Long.MIN_VALUE;

        for(int i=0;i<n;i++) {
            max =(long) (Math.max(max,Math.max(suffix[i],prefix[i])));
        }


        return max;

    }
}
