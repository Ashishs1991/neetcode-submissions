class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = n/2;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums) {
            int freq = map.getOrDefault(i,0);
            if(freq+1>threshold) return i;
            map.put(i,freq+1);
        }
        

        return 0;
    }
}