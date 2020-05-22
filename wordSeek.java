class Solution {

    String notFound = "-1 -1";
    
    class TrieNode{
        TrieNode[] children;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
            word = null;
          
        }        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();

        for(String s: words){
            map.put(s, false);
        }
        if(board == null || board.length == 0) return res;

        
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char c = board[i][j];
                if(root.children[c - 'a'] != null){
                    String row = String.valueOf(i);
                    String col = String.valueOf(j);
                    dfs(board, i, j, root, res, row, col, map);
                }
            }
        }
        
         for (Map.Entry mapElement : map.entrySet()) { 
            String key = (String)mapElement.getKey(); 
             Boolean value = ((boolean)mapElement.getValue());
             
             if(value == false){
            res.add(key + " "+ notFound);
        }
  

        } 

       
        
        
        Collections.sort(res);
        for(int i=0;i<res.size(); i++){
        System.out.println(res.get(i));
            }
        return res;
    }  

     private void buildTrie(TrieNode root, String[] words){
        for(String s : words){
            TrieNode cur = root;
            
            for(char c : s.toCharArray()){
                int index = (int)(c - 'a');
                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            
            cur.word = s;
            
        }
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null){
            return;
        } 
        
        cur = cur.children[c - 'a'];
        
        
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
            map.replace(cur.word, true);
            
            cur.word = null;
        }
        
        board[i][j] = '#';
        
        dfsDown(board, i+1, j, cur, res, row, col, map);
        dfsUp(board, i-1, j, cur, res, row, col, map);
        dfsRight(board, i, j+1, cur, res, row, col, map);
        dfsLeft(board, i, j-1, cur, res, row, col, map);
        dfsRightDown(board, i+1, j+1, cur, res, row, col, map);
        dfsRightUp(board, i+1, j-1, cur, res, row, col, map);
        dfsLeftUp(board, i-1, j+1, cur, res, row, col, map);
        dfsLeftDown(board, i-1, j-1, cur, res, row, col, map);
        
        board[i][j] = c;
        
        
        
    }
    
    private void dfsDown(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsDown(board, i+1, j, cur, res, row, col, map);
        board[i][j] = c;        
    }

       private void dfsUp(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsUp(board, i-1, j, cur, res, row, col, map);
        board[i][j] = c;        
    }

       private void dfsRight(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsRight(board, i, j+1, cur, res, row, col, map);
        board[i][j] = c;        
    }

       private void dfsLeft(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsLeft(board, i, j-1, cur, res, row, col, map);
        board[i][j] = c;        
    }

       private void dfsRightDown(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsRightDown(board, i+1, j+1, cur, res, row, col, map);
        board[i][j] = c;        
    }

       private void dfsRightUp(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsRightUp(board, i+1, j-1, cur, res, row, col, map);
        board[i][j] = c;        
    }

       private void dfsLeftUp(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsLeftUp(board, i-1, j+1, cur, res, row, col, map);
        board[i][j] = c;        
    }

       private void dfsLeftDown(char[][] board, int i, int j, TrieNode cur, List<String> res, String row, String col, Map<String, Boolean> map){
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        
        if(board[i][j] == '#') return;
        char c = board[i][j];
        
        if(cur.children[c-'a'] == null) return;
        
        cur = cur.children[c - 'a'];   
       // Will need to modify this to change the output
        if(cur.word != null){
            res.add(cur.word + " " + row + " " + col);
            //res.add(row);
             map.replace(cur.word, true);
            
            cur.word = null;
        }
        board[i][j] = '#';
        dfsLeftDown(board, i-1, j-1, cur, res, row, col, map);
        board[i][j] = c;        
    }
   
}