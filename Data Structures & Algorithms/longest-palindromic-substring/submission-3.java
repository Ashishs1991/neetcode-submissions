class Solution {
    int maxStart = 0;
    int maxLen = 1;
    int n;

    public String longestPalindrome(String s) {
         n = s.length();

        for(int i=0;i<n;i++) {
            //odd length
            expand(s,i,i);

            // even lenght
            expand(s,i,i+1);
        }
        return s.substring(maxStart,maxStart+maxLen);
    }

    public void expand(String s, int left,int right) {
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)) {
            int len = right - left+1;

            if(len>maxLen) {
                maxLen = len;
                maxStart = left;
            }

            left--;
            right++;
        }
    }
}
