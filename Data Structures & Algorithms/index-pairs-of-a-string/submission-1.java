
class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}
class Solution {
    public int[][] indexPairs(String text,String[] words) {
        
        TrieNode root = new TrieNode();

        //first we will create a trie tree
        

        for(String st: words) {
            TrieNode curr = root;
            for(char ch: st.toCharArray()) {
                if(curr.children[ch-'a']==null) {
                    TrieNode newNode = new TrieNode();
                    curr.children[ch-'a'] = newNode;
                }
                curr = curr.children[ch-'a'];
            }
            curr.endOfWord= true;
        }

        List<int[]> result = new ArrayList<>();

        for(int i=0;i<text.length();i++) {
            TrieNode curr = root;

            for(int j =i;j<text.length();j++) {
                int index = text.charAt(j)-'a';

                if(curr.children[index]==null) {
                    break;
                }

                curr = curr.children[index];
                if(curr.endOfWord) {
                    result.add(new int[]{i,j});
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
