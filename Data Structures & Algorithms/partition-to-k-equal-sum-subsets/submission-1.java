class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {


        int sum = 0;
        int max = 0;

        for(int i: nums) {
            sum+= i;
            max = Math.max(max,i);
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        if(sum%k!=0 || max>sum/k) return false;

        return helper(nums,k,0,sum/k,0,visited);
        
    }

    public boolean helper(int[] nums,int k,int index,int target,int temp, boolean[] visited) {
        if(k==1) {
            return true;
        }

        if (temp == target)return helper(nums, k - 1, 0, target, 0, visited);

        for(int i =index;i<nums.length;i++) {
            if(temp+nums[i]>target || visited[i] ) continue;
            visited[i] = true;
            if (helper(nums, k, i + 1,target,temp + nums[i], visited)) return true;
            visited[i] = false;
        }

        return false;
    }
}