

1. number of groups of node

2. if the nodes are connected

3. path distance to the root



Mistakes:

0. meaning of parent map:

	link to parent node, not necessarily the root


1. initialization
	
	int[] : init with itself or -1

	Map : 

		no init when input is unknown, when union is called, see if containsKey()

		or just init with itself



2. union

	find ir, jr

	change ir or jr's parent


3. find(Path Compression)

	3.1 non recursively


```
		// log*(n) union-find 

		while(i!=parent[i]){
			// link to grandpa
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		return i;
```



	3.2 recursively

```
		// 1 union-find, garanteed with all the path between i and root is compressed
		// thus when use to find path value to root, use this compression
		if(parent[i] == i){
			return i;
		}

		int root = find(parent[i]);

		parent[i] = root;

		return root;
```


