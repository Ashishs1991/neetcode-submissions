class TrieNode {
    TrieNode[] children = new TrieNode[52];
    boolean isEOW;
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr= root;
        for(char c: word.toCharArray()) {
            int index = c-'a';

            if(curr.children[index]==null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEOW=true;
    }

    public boolean search(String word) {
        TrieNode curr= root;
        for(char c: word.toCharArray()) {
            int index = Math.abs(c -'a');
            if(curr.children[index]==null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEOW;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr= root;
        for(char c: prefix.toCharArray()) {
            int index = c -'a';
            if(curr.children[index]==null) {
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }
}
