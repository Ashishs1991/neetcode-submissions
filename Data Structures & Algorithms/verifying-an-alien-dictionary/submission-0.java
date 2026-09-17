class Solution {
    HashMap<Character,Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();

        int index =0;
        for(char c: order.toCharArray()) {
            map.put(c,index++);
        }

        for(int i=0;i<words.length-1;i++) {
            String w1 = words[i], w2 = words[i+1];
            int j=0;

            for(;j<w1.length();j++) {
                if(j == w2.length()) return false;
                if(w1.charAt(j) !=w2.charAt(j)) {
                    if(map.get(w1.charAt(j)) > map.get(w2.charAt(j))) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;        
    }
}