public class Solution {
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            int j = i + 1;
            while (j < n) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                j++;
                count++;
            }
            count = (j == n) ? 0 : count;
            res[i] = count;
        }
        return res;
    }


    public int[] dailyTemperatures(int[] t) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[t.length];

        for(int i=0;i<t.length;i++) {
            int temp = t[i];

            while(!st.isEmpty() && temp>st.peek()[0]) {
                int[] pair = st.pop();
                res[pair[1]] = i-pair[1];
            }

            st.push(new int[]{temp,i});
        }


        return res;

    }
}