
Iterate the nodes, if not visited then:

DFS:
  * color it
  * see neighbors
    * not color, then dfs color to opposite
    * colored, check
  

BFS:
  * color the start
  * put start into q

  * while not empty
    * get cur
    * see neighbors
      * not, then...
      * colored, then...



```
class Solution {
/**		 5
		/
	0---1---2
		|   |
		3---4

	0 1 2 3 4 5

*/
	 


    public boolean isBipartite(int[][] graph) {
        // visited int[]
        if(graph == null || graph.length == 0){
        	return true;
        }

        int[] visited = new int[graph.length];

       	// interate through all the node
       	// if not visited, then dfs to see if is bipar or not

       	for(int i = 0; i < graph.length; i ++){
       		if(visited[i] == 0){
       			if(!dfs(graph, i, visited, 1)){
       				return false;
       			}
       		}
       	}

       	return true;
    }

    // color unvisited node, and start to color its univisited neighbors, start dfs
    // if neighbor visited, just check if it has same color, no dfs

    private boolean bfs(int[][] graph, int start, int[] visited, int color){
    	
    	visited[start] = color;

    	for(int neighbor : graph[start]){
    		if(visited[neighbor] == 0){
    			if(!dfs(graph, neighbor, visited, -color)){
    				return false;
    			}
    		} else {
    			if(visited[neighbor] == visited[start]){
    				return false;
    			}
    		}
    	}

    	return true;
    }
}