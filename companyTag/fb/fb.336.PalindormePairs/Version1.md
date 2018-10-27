

```


class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
		
		Trie trie = new Trie();

    	for(int i = 0; i < words.length; i ++){
    		trie.add(words[i], i);
    	}

    	List<List<Integer>> result = new ArrayList<>();

    	for(int i = 0; i < words.length; i ++){
    		trie.search(words[i], i, result);
    	}

    	return result;

    }



    private class Trie{

    	public Node root;


    	public Trie(){
    		root = new Node();
    	}

    	public void add(String word, int index){

    		Node cur = root;

    		for(int i = word.length()-1; i >= 0; i ++){

    			if(!cur.subtree.containsKey(i)){

    				cur.subtree.put(word.charAt(i), new Node());
    			}

    			cur = cur.subtree.get(word.charAt(i));

    			if(isPalindorme(word, 0, i-1)){
    				cur.list.add(index);
    			}

    		}

    		cur.indexInList = index;

    	}


    	public void search(String leadingWord, int LWIndex, List<List<Integer>> result){

    		Node cur = root;

    		String LW = leadingWord;

    		for(int i = 0; i < LW.length(); i ++){

    			Node matchNode = cur.subtree.get(LW.charAt(i));

    			if(matchNode != null)){

    				// if this is a word end -> if rest of LW is P && this word is not LW
    				
    				int mcIndex = matchNode.indexInList;

    				if(mcIndex != LWIndex && mcIndex != -1){
    					if(isPalindorme(LW, i+1, LW.length()-1)){
    						result.add(new ArrayList<Integer>
    							(Arrays.asList(LWIndex, matchNode.indexInList)));
    					}
    				}

    			}

    			cur = matchNode;

    			if(cur == null){
    				break;
    			}

    		}

    		// cur is the last match node or null when we didnt find a match

    		if(cur != null){

    			for(int i : cur.list){
    				if(i != LWIndex){
    					result.add(new ArrayList<Integer>(Arrays.asList(LWIndex, i)));
    				}
    			}
    		}

    	}
    }

    private class Node{

    	public Map<Character, Node> subtree = new HashMap<>();

    	public int indexInList = -1;

    	public List<Integer> list = new ArrayList<>();


    }


    private boolean isPalindorme(String word, int lo, int hi){

    	while(lo < hi){
    		if(word.charAt(lo++) != word.charAt(hi--)){
    			return false;
    		}
    	}

    	return true;
    }
    
}