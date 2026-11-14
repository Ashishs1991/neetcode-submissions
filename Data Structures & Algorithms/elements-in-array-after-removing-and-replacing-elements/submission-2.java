class Solution {
    public int[] elementInNums(int[] nums, int[][] queries) {

        //4,7,9
        //0 -> 479 ,1 -> 7,9 -> 2 -> 9

        int len = nums.length;

        // at nth time -> the array is empty
        // at n-1th time we will have the last element at the start
        //at n-2th time -> we will have n-2 at the start

        // replenish aswell at n+1

        // we have to check what will be the size at that. time;

        // example at time == len size will be 0 
        // at time > len == size will be time - len and the result[i] = (find index in nums) -> 
        int[] result = new int[queries.length];

        int i = 0;
        for(int[] query : queries) {
            int time = query[0] % (2*len);
            int index = query[1];

            if(time<len) {
                //rElements before position 'time' have been removed.
                int size = len - time;
                result[i] = index < size ? nums[time+index] : -1; 
            }else {
                // replenish the first time - len elements have been apended
                int size = time - len;
                result[i] = index<size ? nums[index] : -1;

            }

            
            i++;
        }
        return result;

    }
}
