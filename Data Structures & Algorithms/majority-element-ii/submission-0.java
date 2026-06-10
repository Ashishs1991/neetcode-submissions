class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int threshold = nums.length/3;
        List<Integer> list = new ArrayList<>();


        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i],count+1);
            }else {
                map.put(nums[i],1);
            }
        }

        for(int i: map.keySet()) {
            if(map.get(i)>threshold) list.add(i);
        }

        return list;
    }
}