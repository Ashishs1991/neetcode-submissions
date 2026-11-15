class TrieNode {
    Map<Character,TrieNode> children;
    boolean isEOW;

    TrieNode() {
        children = new HashMap<>();
        isEOW = false;
    }

    public void addWord(String word) {
        TrieNode curr = this;
        for(char c: word.toCharArray()) {
            curr.children.putIfAbsent(c,new TrieNode());
            curr = curr.children.get(c);
        }

        curr.isEOW = true;
    }
}

class Solution {

    private Set<String> res;
    private boolean[][] visit;
    int ROWS , COLS;
    public List<String> findWords(char[][] board, String[] words) {
        //First we can create a tree of all the words
        TrieNode root = new TrieNode();

        // We have added al the words in TrieNode Tree;
        for(String word: words) {
          root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        for(int r = 0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++) {
                dfs(board,r,c,root,"");
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board,int r, int c, TrieNode node,String word) {
        if (r < 0 || c < 0 || r >= ROWS ||
            c >= COLS || visit[r][c] ||
            !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word+=board[r][c];

        if (node.isEOW) {
            res.add(word);
        }

        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;
    }
}
