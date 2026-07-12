class Solution {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int open =0;
        int close=0;
        helper(0,n,open,close,"");
        return result;
    }

    public void helper(int index,int n,int open,int close,String temp) {

        //when we have to add the result base case
        if(open+close ==2*n && open == close) {
            result.add(temp);
            return;
        }
        //negative base case
        if(open>n) {
            return;
        }


        //we can go to open
        helper(index+1,n,open+1,close,temp+"(");

        if(close<open) {
            helper(index+1,n,open,close+1,temp+")");
        }
    }
}
