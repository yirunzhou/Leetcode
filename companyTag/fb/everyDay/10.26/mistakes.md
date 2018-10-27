

1. copy random list node:

	random pointer may be empty


2. validate BST:

	divide and conqure is WRONG

```
			 10
			/	\
			4	15
				/
				6
```

	this will be valid if we just use the logic with left valid , right valid and compare the root.child


	CAREFUL when update the prev and cur, think about which one you want to update first without let the other one embarrassed(cannot find the value suits for him)


```
	prev = cur;
	cur = cur.right;
```


3. LCA :

	
	findPath():

		return false :

			When root is null

			When we did not find in root.left or root.right

			meanwhile remove the node added before


		return true :

			When root is target

			When we found in left or right


	outside comparing, we just use a 'LCA', init with root

	if two path's ith are the same, update 'LCA', else break

	
