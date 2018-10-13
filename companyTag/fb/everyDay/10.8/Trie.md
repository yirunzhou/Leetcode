
```
class WordDictionary {

    /** Initialize your data structure here. */

    class Node{
    	public Map<Character, Node> subtree = new HashMap<>();
    	public boolean isEnd = false;
    	public String content = "";
    }


    private Node root;


    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */

    public void addWord(String word) {
    	Node cur = root;
    	for(int i = 0; i < word.length(); i ++){
    		if(!cur.subtree.containsKey(word.charAt(i))){
    			cur.subtree.put(word.charAt(i), new Node());
    		}
    		cur = cur.subtree.get(word.charAt(i));
    	}
    	cur.isEnd = true;
    	cur.content = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    // try to find word.charAt(index) in cur.subtree
    private boolean helper(String word, int index, Node cur){

    	if(index == word.length()){
    		return cur.isEnd;
    	}

    	boolean found = false;
    	if(word.charAt(index) == '.'){
    		for(Node child : cur.subtree.values()){
    			found = found || helper(word, index + 1, child);
    			if(found){
    				break;
    			}
    		}
    	} else {
    		if(cur.subtree.containsKey(word.charAt(index))){
    			found = helper(word, index + 1, cur.subtree.get(word.charAt(index)));
    		} else {
    			found = false;
    		}
    	}

    	return found;
    }


    private Node searchNode(String word, int index, Node cur){

    	if(index == word.length()){
    		return cur;
    	}

    	Node node = null;

    	if(word.charAt(index) == '.'){

    		for(Node child : cur.subtree.values()){
    			Node temp = searchNode(word, index + 1, child);
    			if(node == null && temp != null){
    				node = temp;
    			}
    			if(temp != null && node != null && !node.isEnd && temp.isEnd){
    				node = temp;
    			}
    			if(node.isEnd){
    				break;
    			}
    		}

    	} else {

    		if(!cur.subtree.containsKey(word.charAt(index))){
    			node = null;
    		} else {
    			node = searchNode(word, index + 1, cur.subtree.get(word.charAt(index)));
    		}

    	}

    	return node;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


 ```