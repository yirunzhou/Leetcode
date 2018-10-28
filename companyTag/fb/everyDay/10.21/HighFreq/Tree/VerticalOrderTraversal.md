



1. Level order bfs the tree
	
	with wrapper class containing col index and node
	put cur node's value into the coresponding map
	update max and min

2. use max min to construct the result list


Time : O(n)

Space: O(n)



**Mistakes:**

1. return type, is 2D integer, not 2D tree node

2. as the order of the output is from top to bottom, we cannot use dfs, only bfs works

3. map's value type should be list, not set, as the ORDER matters

4. not all bfs need level breaker



```

class Solution {
    int max = 0;
    int min = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        // vertical index to the collumn
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        levelOrder(map, root);
        
        for(int i = min; i <= max; i ++){
            
            result.add(map.get(i));
            
        }
        
        return result;
    }
    
    private void levelOrder(Map<Integer, List<Integer>> map, TreeNode root){
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(0, root));
        
        while(!queue.isEmpty()){
                
            Pair cur = queue.poll();

            max = Math.max(max, cur.index);
            min = Math.min(min, cur.index);

            if(!map.containsKey(cur.index)){

                map.put(cur.index, new ArrayList<Integer>());

            }

            map.get(cur.index).add(cur.node.val);

            if(cur.node.left != null){

                queue.offer(new Pair(cur.index -1, cur.node.left));

            }

            if(cur.node.right != null){

                queue.offer(new Pair(cur.index +1, cur.node.right));

            }
            
        }
        
    }

    private class Pair{
        int index;
        TreeNode node;
        public Pair(int i, TreeNode n){
            index = i;
            node = n;
        }
    }
}

```
