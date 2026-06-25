class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();


        if(s.length()<2) return s.length();

        int start=0;
        int length =0;

        for(int end=0;end<s.length();end++) {
            char ch = s.charAt(end);

            if(map.containsKey(ch)) {
                start = Math.max(start,map.get(s.charAt(end))+1);
            }
            map.put(ch,end);
            length= Math.max(length,(end-start)+1);
        }
        return length;
    }
}
