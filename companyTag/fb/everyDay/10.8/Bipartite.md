```


public boolean isBipartite(int[][] graph){

  int[] visited = new int[graph.length];

  for(int i = 0; i < graph.length; i ++){
    if(!visited.contains(i)){
      if(!dfs(graph, i, visited, 1)){
        return false;
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
      if(visited[nei] == visited[start]){
        return false;
      }
    }
  }

  return true;
}



```
```
public boolean isBipartite(int[][] graph){


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

private boolean bfs(int[][] graph, int start, int[] visited){

  visited[start] = 1;

  Queue<Integer> queue = new LinkedList<>();
  queue.offer(start);

  while(!queue.isEmpty()){
    int cur = queue.poll();

    for(int nei : graph[cur]){

      if(visited[nei] == 0){
        visited[nei] = 0 - visited[cur];
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

```