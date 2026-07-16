class Solution {
    public String longestCommonPrefix(String[] strs) {
        String temp = "";
        Arrays.sort(strs);

        for(int i=0;i<strs.length;i++) {
            if(i==0) {
                temp = strs[i];
                continue;
            }

            temp = compareString(temp,strs[i]);
        }

        return temp;
    }

    public String compareString(String temp, String str) {

    while (!str.startsWith(temp)) {

        temp = temp.substring(0, temp.length() - 1);

    }

    return temp;

}
}