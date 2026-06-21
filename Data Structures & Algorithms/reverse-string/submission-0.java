class Solution {
    public void reverseString(char[] s) {
        
        int n = s.length;
        int left =0;
        int right=n-1;

        while(left<right) {
            swap(s,left++,right--);
        }
    }


    public void swap(char[] s,int index1,int index2) {
        char c= s[index1];
        s[index1]= s[index2];
        s[index2] = c;
    }
}