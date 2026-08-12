class Solution {
    public int firstMissingPositive(int[] nums) {
        int h = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;

        //this will give us the bounds
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) {
            h = Math.max(h,i);
            if(!set.contains(i)) set.add(i);
        }

        //1 -- 6

        if(h<=0) return 1;
        

        int min = Integer.MAX_VALUE;
        int temp = h;
        

        for(int i =1;i<=h;i++) {
            if(!set.contains(i)) return i;
        }

        return h+1;
    }
}