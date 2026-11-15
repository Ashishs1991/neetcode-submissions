class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    public int countDistinct(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        for(int start =0;start<s.length();start++) {
            TrieNode curr = root;
            for(int end =start; end<s.length();end++) {
                int index = s.charAt(end) -'a';

                if(curr.children[index]==null) {
                    curr.children[index] = new TrieNode();
                    count++;
                }
                curr = curr.children[index];
            }
        }

        return count;
    }
}
