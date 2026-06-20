class Solution {
    public int majorityElement1(int[] nums) {
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
    //O(1) space
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length-1;
        int mid=n/2;
        int left = 0;

        while(nums[left]!=nums[mid]) {
            left++;
            mid++;
        }

        return nums[left];
    }
}