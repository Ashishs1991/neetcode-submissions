class Solution {
    public long numberOfSubstrings(String s) {
        long[] counts = new long[26];
        long answer = 0;
        for (char c : s.toCharArray()) answer += ++counts[c - 'a'];
        return answer;
    }
}
