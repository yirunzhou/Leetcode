```
    
class WordDictionary {
    private Node root = new Node();
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        // look at whether cur has a subtree represent word[i]
        Node cur = root;
        
        for(int i = 0; i < word.length(); i ++){
            
            if(!cur.subtree.containsKey(word.charAt(i))){
                
                cur.subtree.put(word.charAt(i), new Node());
            
            }
            
            cur = cur.subtree.get(word.charAt(i));
        
        }
        
        cur.isEnd = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        Node cur = root;
        
        for(int i = 0; i < word.length(); i ++){
            
            if(!cur.subtree.containsKey(word.charAt(i))){
                return false;
            }
            
            cur = cur.subtree.get(word.charAt(i));
        }
        
        return cur.isEnd;
    }
    
    
    public boolean searchWithDot(String word){
        
        return helper(word, root, 0);
    
    }
    
    
    // return true if found
    
    // cur is the root, we are trying to find word[index] in cur's subtree
    private boolean helper(String word, Node cur, int index){
        
        // base case
        if(index == word.length()){
            return cur.isEnd;
        }
        
        
        if(word.charAt(index) == '.'){
            
            for(Node child : cur.subtree.values()){
            
                if(helper(word, child, index +1)){
                    return true;
                }
                
            }
            
            return false;
            
        } else {
            
            if(!cur.subtree.containsKey(word.charAt(index))){
                return false;            
            }
            
            return helper(word, cur.subtree.get(word.charAt(index)), index + 1);
        
        }
        
    }
    
    
    
    public void insertWithDot(String word){
        
        insertHelper(word, root, 0);
        
    }
    
    // try to insert a dot or char to the cur's subtree
    private void insertHelper(String word, Node cur, int index){
        
        if(index == word.length()){
            cur.isEnd = true;
            return;
        }
        
        
        if(!cur.subtree.containsKey('.')){
            
            cur.subtree.put('.', new Node());
                
        }
        
        insertHelper(word, cur.subtree.get('.'), index + 1);

        
        
        if(!cur.subtree.containsKey(word.charAt(index))){
        
            cur.subtree.put(word.charAt(index), new Node());
            
        }
        
        insertHelper(word, cur.subtree.get(word.charAt(index)), index + 1);
    
    }
    
    
    private class Node{
        
        public Map<Character, Node> subtree;
        
        public boolean isEnd;
        
        public Node(){
            subtree = new HashMap<>();
            isEnd = false;
        }
        
    }
}
