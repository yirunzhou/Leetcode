
```

class Trie{

	class Node{
		public Map<Character, Node> subtree = new HashMap<>();
		public String content = "";
		public boolean isEnd = false;
	}

	private Node root;

	public Trie(){
		root = new Node();
	}

	public void insert(String word){
		Node cur = root;

		for(int i = 0; i < word.length(); i ++){
			char c = word.charAt(i);
			if(!cur.subtree.containsKey(c)){
				cur.subtree.put(c, new Node());
			}
			cur = cur.subtree.get(c);
		}

		cur.content = new String(word);
		cur.isEnd = true;
	}

	public boolean searchPrefix(String prefix){
		return searchNode(prefix) != null;
	}


	private Node searchNode(String word){
		Node cur = root;

		for(int i = 0; i < word.length(); i ++){
			if(!cur.containsKey(word.charAt(i))){
				return null;
			}
			cur = cur.subtree.get(word.charAt(i));
		}

		return cur;
	}


	public boolean searchWord(String word){
		return searchHelper(word, 0, root);
	}

	private boolean searchHelper(String word, int i, Node cur){
		if(i == word.length()){
			return cur.isEnd;
		}

		boolean found = false;

		if(word.charAt(i) == '.'){
			for(Node child : cur.subtree.values()){
				found = found || searchHelper(word, i + 1, child);
				if(found){
					break;
				}
			}
		} else {
			if(!cur.subtree.containsKey(word.charAt(i))){
				found = false;
			} else {
				found = true;
			}
		}

		return found;
	}
}