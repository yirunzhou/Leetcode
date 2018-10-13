```

class LRUCache {

	private int capa;
	private Map<Integer, Node> map;
	private DList dList;

    public LRUCache(int capacity) {
    	capa = capacity;
    	map = new HashMap<>();
    	dList = new DList();  
    }
    
    public int get(int key) {

    	if(!map.containsKey(key)){
    		return -1;
    	}

        Node target = map.get(key);

        dList.delete(target);
        dList.add(target);

        return target.val;
    }
    
    public void put(int key, int value) {
        // if exist -> delete and add 

        if(map.containsKey(key)){
        	Node target = map.get(key);

        	dList.delete(target);
        	dList.add(target);

        	target.val = value;
        }


        else {

        	if(map.size() == capa){
        		Node toDelete = dList.head.next;
        		dList.delete(toDelete);
        		map.remove(toDelte.key);
        	}

        	Node toAdd = new Node(key, value);
        	dList.add(toAdd);
        	map.put(key, toAdd);
        }

    }


    private class DList{

    	public Node head;

    	public DList(){
    		head = new Node(0, 0);
    		head.prev = head;
    		head.next = head;
    	}

    	public void add(Node node){
    		Node tail = head.prev;

    		tail.next = node;
    		node.prev = tail;
    		node.next = head;
    		head.prev = node;
    	}

    	public void delete(Node node){
    		Node prev = node.prev;
    		Node next = node.next;
    		prev.next = next;
    		next.prev = prev;
    	}
    	
    }

    private class Node{
	    	public Node prev;
	    	public Node next;
	    	public int val;
	    	public int key;

	    	public Node(int _key, int _val){
	    		val = _val;
	    		prev = null;
	    		next = null;
	    		key = _key
	    	}
    	}

    


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */