class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int left =0;
        int right =n-1;
        s = s.toLowerCase();
        // Was it a car or a cat I saw?

        while(left<right) {
             if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }


        return true;
    }
}
