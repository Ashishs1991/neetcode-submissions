class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {

        result = new ArrayList<>();
        int open =0;
        int close =0;
        helper(0,n,open,close,"");
        return result;
    }

    public void helper(int index,int n,int open,int close,String s) {
        if(open+close == 2*n && open == close) {
            result.add(s);
            return ;
        }

        if(open>n) {
            return;
        }

        helper(index+1,n,open+1,close,s+"(");

        if(close<open) {
            helper(index+1,n,open,close+1, s+")");
        }
    }
}
