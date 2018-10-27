mistakes.md


1. 3sum

	dedup

	if(i != 0 && candidates[i] == candidates[i-1]){
		continue;
	}

	be carefull when to i ++, or continue, if you are in a for loop, or while loop



2. binary search

	[r, l] is the searching bound

	init lo and hi with r, l

	[l, lo) is range A
	(hi, r] is range B

	[hi, lo] is undefined


	so initally, there is no value in A or B


	search untile lo > hi -> nothing in undefined range:

		every time we got a mid, we consider put mid into range A or range B

		in range A, then lo = mid + 1; B then..


	thus lo-1 is the last value of range A,
	     hi+1 is the first value of range B


3. account merge

	union find, parent map is the parent string, not root string, may be root after path compression, so we need to use while(!parent.get(s).equals(s))) or recursion to get the root node
```
	while(!parent.get(s).equals(s)){
		parent.put(s, parent.get(parent.get(s)));

		s = parent.get(s);
	}

	return s;

```

```
	if(!parent.get(s).equals(s)){

		String root = find(parent.get(s));

		parent.put(s, root);

	}

	return parent.get(s);
```


	when using Aux Functions, with multiple return type, check the return type

	when constructing nested lists, creating new sublist, 

	do not forget to add it to result list at last


	map's name !!!!!



3. longest substring with at most k distinct char

	be carefull about the sequence of you parameter in the helper function


4. queue does not have pop !!!!!!!!!!!


5. binary search:
	
	first bad version :

		(hi, r] is bad version range

		Thus return hi + 1


	search in rotated sorted array:

		EMPTY CHECK when using lo, hi index 


		upper bound and lower bound
		LO = 0
		HI = NUMS.LENGTH -1


		1) dup? -> then cannot judge where it is sorted, CONTINUE!!

		2) right sorted should be judge with n[mid] <= n[hi], if == not consider, then we will consider left part as sorted, which is wrong


	search range :

		double check your +1 or -1 operation

		mark the flag if the result is found

		do not DUP DECLEAR the lo , hi in SECOND SEARCH


6. draw the array with index to figure out the calculation of pointers boundary


7. level order bfs:

		declear level var at OUTSIDE of the while(!queue.isEmpty()){}, otherwise the level will always be 1


		when the problem may not have solution, use a boolean flag to indicate, return an invalid when !flag

8. Meeting Room II

		scaning line solution will need Comparator for <Pair>, not for <Interval>

		pq's initial capacity cannot be 0, when pass in the length of a array, be sure to rule out EMPTY



9. number of islands II

		index function i * col + j

		not i * row + j


10. clone graph

	// map's name
    // neighbors is attribute not method
    // be sure about what you are adding, add copy node to copy node's neighbor list
   

11. nested Integer
	
```
	
	private Integer val;

	private List<NestedInteger> = new ArrayList<>();

----

	public NestedInteger(int val)

	public boolean isInteger()

	public Integer getInteger()

	public Integer setVal()

	public List<NestedInteger> getList()

	public void add(int val)


```




12. power of a

	no use / * 


	a * a

	times = 1;

	while(times + times <= a){



	}


13. telephone

		recursive:

			imagine the recursive tree

			thus dfs with backtracking prefix

		iterative:

			do not forget the start point, otherwise it will never add anything


14. multiply string


		when dealing with atoi problem

		careful the string type, method, name


		double for loop, do not declear iterating variable OUTSIDE

		when you do that, after the inner loop is terminated, it will never enter the inner loop when in next outer loop


		changing POINTER INSIDE WHILE -> CHECK BOUND !!!!
		after the while -> CHECK BOUND AGAIN !!!!


		print cost time!


15. permutation sequence

		-> n permutation is N Factorial

16. bigInteger

		-> when use a new var, check if it has been decleared

17. mergeIntervalList

		pq's Generic type

		



