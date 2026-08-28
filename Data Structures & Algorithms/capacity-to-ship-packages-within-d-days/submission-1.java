class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int total = 0;
        int max = -1;

        for(int i:weights) {
            max= Math.max(max,i);
            total+=i;
        }

        int result = total;

        while(max<=total) {
            int cap = max+(total-max)/2;
            if(canShip(weights,days,cap)) {
                result = Math.min(result,cap);
                total = cap-1;
            } else {
                max = cap+1;
            }
        }

        return result;       
    }

    public boolean canShip(int[] weights, int days,int cap) {
        int ships=1;
        int currentCap = cap;

        for(int w: weights) {
            if(currentCap - w < 0) {
                ships++;
                if(ships > days) {
                    return false;
                }
                currentCap = cap;
            }

            currentCap = currentCap - w;
        }
        return true;
    }
}