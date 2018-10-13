
```
public boolean isBipartite(int[][] graph){
	int[] visited = new int[graph.length];

	for(int i = 0; i < graphh.length; i ++){
		if(visited[i] == 0){
			if(!bfs(graph, i, visited)){
				return false;
			}
		}
	}

	return true;
}

private boolean bfs(int[][] graph, int start, int[] visited){
	visited[start] = 1;
	Queue<Integer> queue = new LinkedList<>();
	queue.offer(start);

	while(!queue.isEmpty()){
		int cur = queue.poll();
		for(int nei : graph[cur]){
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


private boolean dfs(int[][] graph, int start, int[] visited, int color){

	visited[start] = color;

	for(int nei : graph[start]){
		if(visited[nei] == 0){
			if(!dfs(graph, nei, visited, -color)){
				return false;
			}
		} else {
			if(visited[start] == visited[nei]){
				return false;
			}
		}
	}

	return true;
}


