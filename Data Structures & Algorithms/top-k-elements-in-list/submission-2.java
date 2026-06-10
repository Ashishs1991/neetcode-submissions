
class Frequent implements Comparable<Frequent> {
    int num;
    int frequency;

    Frequent(int num,int frequency) {
        this.num = num;
        this.frequency = frequency;
    }

    public int compareTo(Frequent frequent) {
        return frequent.frequency- this.frequency;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Frequent> pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i])+1;
                map.put(nums[i],count);
            }else {
                map.put(nums[i],1);
            }
        }

        for(int i : map.keySet()) {
            pq.add(new Frequent(i,map.get(i)));
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++) {
            result[i] = pq.poll().num;
        }

        return result;
    }
}
