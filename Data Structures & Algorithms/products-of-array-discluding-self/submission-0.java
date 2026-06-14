class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProd=1;
        int countZero=0;
        for(int i: nums) {
            if(i==0) {
                countZero++;
                continue;
            }
            totalProd*=i;
        }

        if(countZero>1) {
            Arrays.fill(nums,0);
            return nums;
        }

        if(countZero==1) {
            for(int i=0;i<nums.length;i++) {
                if(nums[i]!=0) nums[i]=0;
                else nums[i] = totalProd;
            }

            return nums;
        }

         for(int i=0;i<nums.length;i++) {
            nums[i] = totalProd/nums[i];
        }
        
        return nums;
    }
}  
