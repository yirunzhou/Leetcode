```

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null){
        	return null;
        }

    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    	Queue<UndirectedGraphNode> queue = new LinkedList<>();

    	queue.offer(node);

    	map.put(node, new UndirectedGraphNode(node.label));



    	while(!queue.isEmpty()){

    		UndirectedGraphNode cur = queue.poll();

    		for(UndirectedGraphNode n : cur.neighbors){

    			if(!map.containsKey(n)){
    				map.put(n, new UndirectedGraphNode(n.label));
    				queue.offer(n);
    			}

    		}

    	}



    	for(UndirectedGraphNode origin : map.keySet()){

    		UndirectedGraphNode copy = map.get(origin);

    		for(UndirectedGraphNode originNei : origin.neighbors){

    			copy.neighbors.add(map.get(originNei));

    		}

    	}

    	return map.get(node);

    }
}