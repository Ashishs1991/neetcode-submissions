class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //take one index
        int minLimit = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int num: preorder) {

            while(!stack.isEmpty() && stack.peek()<num) {
                minLimit = stack.pop();
            }

            if(num<= minLimit) {
                return false;
            }

            stack.push(num);
        }    
        
        return true;
    }
}
