
```

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
   		
   		int max = 0;
   		int min = 0;

   		Queue<Tuple> queue = new LinkedList<>();

   		queue.offer(new Tuple(0, root));
   		

   		Map<Integer, List<Integer>> map = new HashMap<>();

   		while(!queue.isEmpty()){

   			Tuple cur = queue.poll();

   			max = Math.max(max, cur.index);
   			min = Math.min(min, cur.index);

   			if(!map.containsKey(cur.index)){
   				map.put(cur, new ArrayList<Integer>());
   			}

   			map.get(cur.index).add(cur.node.val);

   			if(cur.node.left != null){
   				queue.offer(new Tuple(cur.index-1, cur.node.left));
   			}

   			if(cur.node.right != null){
   				queue.offer(new Tuple(cur.index+1, cur.node.right));
   			}

   		}


   		List<List<Integer>> result = new ArrayList<>();

   		for(int i = min; i <= max; i ++){
   			result.add(map.get(i));

   		}

   		return result;
    }

    private class Tuple{

    	public int index;

    	public TreeNode node;

    	public Tuple(int _index, TreeNode _node){
    		node = _node;
    		index = _index;
    	}
    }
}