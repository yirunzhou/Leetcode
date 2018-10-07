
* how to write attribute and how to init attribute in constructor
* do not rush
* helper(word, i, cur) means to find whethere there is a match in cur's subtree to word[index, length-1], just think about the root's operation, we are going to find whether there is a match in root's child to word[0, length-1]

```

class WordDictionary {
	class Node{
		public Map<Character, Node> subtree = new HashMap<>();
		public boolean isEnd = false;
	}




    /** Initialize your data structure here. */


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
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int i, Node cur){

    	// exit
    	if(i == word.length()){
    		return cur.isEnd;
    	}

    	// . 
    	boolean found = false;
    	if(word.charAt(i) == '.'){
    		for(Node child : cur.subtree.values()){
    			found = found || helper(word, i+1, child);
    			if(found){
    				break;
    			}
    		}
    	}

    	// normal char
    	 else {
    	 	if(!cur.subtree.containsKey(word.charAt(i))){
    	 		found = false;
    	 	} else {
    	 		found = helper(word, i+1, cur.subtree.get(word.charAt(i)));
    	 	}
    	}

    	return found;
    }


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */