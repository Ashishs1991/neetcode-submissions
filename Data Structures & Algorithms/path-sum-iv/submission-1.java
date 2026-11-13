
class Solution {
    HashMap<Integer,Integer> map;
    public int pathSum(int[] nums) {
        //Start wwith creating atree using pre order traversal
        // and than use DFS for calculating the path sum

        // or 
        // we can create a HashMap
        // Or adjacency List like a graph and than calculate; sow e will have the relation but not sure 
        // If we are able to get the data werather thius ios a leve or not

         map = new HashMap<>();

        //Decode each number and add it in HashMap

        for(int i: nums) {
            int key = i/10;
            int value = i % 10;

            map.put(key,value);
        }

        // 11 -> 3 , 21 -> 5 , 22 -> 1

        // Find children from the Node for every Key
        

        return dfs(11,0);
    }


    public int dfs(int key, int currentSum) {
        if(!map.containsKey(key)) {
            return 0;
        }

        currentSum += map.get(key);
        int depth = key/10;
        int position = key %10;

        int leftKey = (depth + 1) *10 + (position * 2 -1);
        int rightKey = (depth + 1) *10 + (position * 2);

        boolean hasLeftKey = map.containsKey(leftKey);
        boolean hasRightKey = map.containsKey(rightKey);

        if(!hasLeftKey && !hasRightKey) return currentSum;

        return dfs(leftKey, currentSum) + dfs(rightKey, currentSum);
    }
}
