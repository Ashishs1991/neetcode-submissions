class TrieNode {
    TrieNode[] children;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
}

class PrefixTree {
    TrieNode root;

    PrefixTree() {
        root = new TrieNode();
    }

    public void add (String word, int length) {
        TrieNode curr = root;      
        for(int i = 0;i<length;i++) {
            int index = word.charAt(i)-'a';
            if(curr.children[index]==null) {
                curr.children[index] = new TrieNode();
            }
            curr=curr.children[index];
            curr.count++;
        }
    }

    public int count(String pref) {
            TrieNode curr = root;
            for(char c: pref.toCharArray()) {
                int index = c-'a';

                if(curr.children[index]==null) {
                    return 0;
                }

                curr = curr.children[index];
            }

            return curr.count;
        }
}
class Solution {
    public int prefixCount(String[] words, String pref) {
        PrefixTree tree = new PrefixTree();

        for(String word : words) {
            if(word.length()>= pref.length()) {
                tree.add(word,pref.length());
            }
        }

        return tree.count(pref);
    }
}