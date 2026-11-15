class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEOW;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(root,0,word);
    }

    public boolean dfs(TrieNode root,int j,String word) {
        TrieNode curr = root;

        for(int i=j;i<word.length();i++) {
            char c = word.charAt(i);
            if(c=='.') {
                for(TrieNode child : curr.children) {
                    if(child!=null && dfs(child,i+1,word)) return true;
                }

                return false;
            }else {
                if(curr.children[c-'a'] ==null) {
                    return false;
                }

                curr = curr.children[c-'a'];
            }
        }
        return curr.isEOW;
    }
}
