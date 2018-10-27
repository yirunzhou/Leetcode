
```

1---2		
|	|
3---0

5---4
|	|
6---7


color 0, then look at neighbors

	if neighbor not colored
		color it to oppsite color
		need to iterate its neightbor -> put into queue

	else 
		check if it is the same color



visited[i] = 1	-> v set
visited[i] = -1 -> u set
visited[i] = 0  -> univisted


T:O(N)
S:O(N)


public boolean isBipartite(int[][] graph) {


	if(graph == null || graph.length == 0){

		return true;
	}

	
	int[] visited = new int[graph.length];

	for(int i = 0; i < graph.length; i ++){

		if(!bfs(graph, i, visited)){
			return false;
		}

	}

	return true;

}


private boolean bfs(int[][] graph, int start, int[] visited){

	visited[start] = 1;

	Queue<Integer> queue = new LinkedList<>();


	while(!queue.isEmpty()){

		int cur = queue.poll();

		for(int nei : graph[start]){

			if(visited[nei] == 0){

				visited[nei] = -visited[cur];

				queue.offer(nei);

			} else {

				if(visited[nei] == visited[cur]){

					return false;
				}
			}

		}

	}


	return true;

}