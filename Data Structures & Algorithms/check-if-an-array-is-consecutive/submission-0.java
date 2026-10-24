class Solution {
    public boolean isConsecutive(int[] nums) {
        int small = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) {
            small = Math.min(small,i);
            if(set.contains(i)) return false;

            set.add(i);
        }


        int max = small+nums.length-1;

        

        for(int i=small;i<=max;i++) {
            if(!set.contains(i)) return false;
        }


        return true;

    }
}
