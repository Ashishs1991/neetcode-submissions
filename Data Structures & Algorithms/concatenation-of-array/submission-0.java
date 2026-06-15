class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[n*2];

        int i = 0;
        while(i<n*2) {
            if(i<n) {
                result[i] = nums[i];
            }
            if(i>=n) {
                result[i] = nums[i%n];
            }
            i++;
        }

        return result;

    }
}