

/**
	get(int key) - return the value, if not exisits then -1
	put(int key, int val) - update cache, if larger than capa, delete LR element
*/

public class LRUCache{
	private Map<Integer, Node> map;
	private Node head;
	private Node tail;
	private final int CAPACITY;

	public LRUCache(int capacity){
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail; 	// CATCH: do not forget to init the link of doubly linked list
		tail.next = prev;
		CAPACITY = capacity;
	}

	public int get(int key){
		// get the node, if it is null, then -1, otherwise, refresh the cache
		Node result = map.get(key);
		if(result == null){
			return -1;
		} else {
			remove(result);
			add(result);
			return result.val;
		}
	}

	public void put(int key, int value){
		// not exist
		// -> add into tail, update cache, check if > CAPA, is then delete LR, update map
		if(!map.containsKey(key)){
			Node newNode = new Node(key, value);
			add(newNode);
			map.put(key, newNode);
			if(map.size() > CAPACITY){
				int keyToRemove = head.next.key;
				map.remove(keyToRemove);
				remove(head.next);
			}
		} else {
			// exisits
			// -> refresh cache, update map
			Node previous = map.get(key);
			Node newNode = new Node(key, value);
			remove(previous);
			add(newNode);
			map.put(key, newNode);
		}
	}

	// get the node from hashmap
	private void remove(Node node){
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	// only add to tail
	private void add(Node node){
		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
	}

	private class Node{
		private Node prev;
		private Node next;
		private int val;
		private int key;
		public Node(int _key, int _val){
			prev = null;
			next = null;
			val = _val;
			key = _key;
		}
	}
}




/*
	find and delete element in O(1) time, meanwhile update the cache
	
	get(key):
		using map to return the value
		refresh the cache

	put(key, value):
		if exisit
			update map, cache
		else 
			update map, cache
			if larger than CAPA
				delete LR element
	
	need some data strucutrue to maintain the order of cache
	O(1) time to get the element, update element to the end of cache
	delete element from head of cache
	delete elemetn in the middle of the cache

	
	linked list + map

	key <-> node(dblinkedlist)
	add : append to tail, update map
	refresh : delete node from list, append to tail, update map
	delete : delete node from head, update map
*/