class TrieNode {
    
    TrieNode[] children = new TrieNode[26];
    boolean isEOW;
    String word;
}

class Solution {
    public String longestWord(String[] words) {
        // Arrays.sort(words);

        TrieNode root = new TrieNode();

        for(String word: words) {
            TrieNode curr = root;

            for(char c: word.toCharArray()) {
                int index = c-'a';

                if(curr.children[index]==null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }    

            curr.isEOW=true;
            curr.word = word;
        }

        return dfs(root,"");
    }


    public String dfs(TrieNode root,String best) {
        for(TrieNode child : root.children) {
            if(child==null || !child.isEOW) {
                continue;
            }

            if (child.word.length() > best.length()) {
                best = child.word;
            }

            best = dfs(child, best);
        }

        return best;
    }
}
