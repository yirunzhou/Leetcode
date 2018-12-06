


```


class WordDictionary {
	private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    /**
		Add all possible path with original word and .

    */
    public void addWord(String word) {
        addHelper(root, word, 0);
    }

    /**
		add word[level] or . to cur's subtree

		Time:
			2^n
		Space:
			2^n
		
    */
    private void addHelper(Node cur, String word, int level){

    	// base
    	if(level == word.length()){
    		cur.isEnd = true;
    		return;
    	}

    	// word[level]

    	if(!cur.subtree.containsKey(word.charAt(level))){
    		cur.subtree.put(word.charAt(level), new Node());
    	}

    	addHelper(cur.get(word.charAt(level), word, level +1));

    	// .

    	if(!cur.subtree.containsKey('.'){
    		cur.subtree.put('.', new Node());
    	}

    	addHelper(cur.get('.'), word, level + 1);

    }

    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	
    	Node cur = root;

    	// find in the cur's subtree contains word[i] or not

    	for(int i = 0; i < word.length(); i ++){

    		if(!cur.containsKey(word.charAt(i))){
    			return false;
    		}

    		cur = cur.get(word.charAt(i));

    	}

    	return cur.isEnd;
    }



    private class Node{

    	public Map<Character, Node> subtree = new HashMap<>();

    	public boolean isEnd = false;

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */