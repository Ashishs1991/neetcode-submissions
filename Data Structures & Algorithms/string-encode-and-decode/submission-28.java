class Solution {

    public String encode(List<String> strs) {
        // we read every word

        String encoded = "";

        for(String s: strs) {
            encoded+=Integer.toString(s.length())+"@"+s;
        }

        // System.out.println(encoded);


        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i =0;

        while(i<str.length()) {
            int j = i;
            while(str.charAt(j)!='@') j++;
            int len = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1,j+1+len);
            decoded.add(word);
            i=j+1+len;
        }

        
        return decoded;
    }

    public List<String> decode1(String str) {

    List<String> decoded = new ArrayList<>();

    int i = 0;

    while (i < str.length()) {

        int j = i;

        while (str.charAt(j) != '@') {
            j++;
        }

        int len = Integer.parseInt(str.substring(i, j));

        String word = str.substring(j + 1, j + 1 + len);

        decoded.add(word);

        i = j + 1 + len;
    }

    return decoded;
}
}
