

1. shortest path, do not forget to update the level variable, and to test is this level or level +1 to return

origin2 change


2. there are many ways to mark visited, change matrix
	and be sure to use it to scan to decide whether to visit the neighbors

3. to find the shortest path, it is ok to not cover all the path using bfs, as we just care about shortest, the path overlap with visited cell will never be the shortest


4. when dealing with graph, avoid NULL POINTER EXCEPTION after graph.get(cur) to get children

	1/. init with all the nodes with empty Set or List
	2/. check after we get the children, children == null ? 


