class Solution {
    public int evalRPN(String[] nums) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<nums.length;i++) {
            if(nums[i].equals("+")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a+b);
            }else if (nums[i].equals("-")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a-b);
            }else if (nums[i].equals("*")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a*b);
            }else if (nums[i].equals("/")) {
                int b = st.pop();
                int a = st.pop();
                if(b!=0) {
                    st.push(a/b);
                }else {
                    st.push(0);
                }
            }else {
                st.push(Integer.parseInt(nums[i]));
            }
        }
        
        return st.pop();
    }
}
