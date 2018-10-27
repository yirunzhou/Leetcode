```


class Solution {
    public boolean isBipartite(int[][] graph) {
    	if(graph == null || graph.length == 0){
    		return true;
    	}

        int[] visited = new int[graph.length];

        for(int i = 0; i < graph.length; i ++){

        	if(visited[i] == 0){
        		if(!bfs(graph, i, visited)){
        			return false;
        		}
        	}

        }

        return true;
    }

    private boolean bfs(int[][] graph, int i, int[] visited){

    	visited[i] = 1;

    	Queue<Integer> queue = new LinkedList<>();

    	queue.offer(i);

    	visited.offer(i);



    	while(!queue.isEmpty()){

    		int cur = queue.poll();

    		for(int n : graph[cur]){

    			if(visited[n] == 0){

    				visited[n] = -visited[cur];

    				queue.offer(n);

    			} else {

    				if(visited[n] == visited[cur]){
    					return false;
    				}

    			}
    			
    		}

    	}

    	return true;
    }
}