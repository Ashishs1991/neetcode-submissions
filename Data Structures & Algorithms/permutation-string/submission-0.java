class Solution {

    int[] s1Arr = new int[26];
    int[] s2Arr = new int[26];
    public boolean checkInclusion(String s1, String s2) {

        int left = 0;
        int right = s1.length();

        if(right>s2.length()) return false;

        //fill in for s1
        for(char c: s1.toCharArray()) {
            s1Arr[c-'a']++;
        }

        while(right<=s2.length()) {
            if(compare(s2.substring(left,right))) return true;
            left++;
            right++;
        }
        
        return false;
    }

    public boolean compare(String s2) {
        for(char c: s2.toCharArray()) {
            s2Arr[c-'a']++;
        }

        //compare both arrays;

        for(int i=0;i<s1Arr.length;i++) {
            if(s1Arr[i]!=s2Arr[i]){
                Arrays.fill(s2Arr,0);
                 return false;
            }
        }

        Arrays.fill(s2Arr,0);
        return true;
    }
}
