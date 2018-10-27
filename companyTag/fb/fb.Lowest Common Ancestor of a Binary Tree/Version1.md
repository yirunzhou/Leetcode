
```
/**
	search for p, q


				l	r		return
	case1: 		null	null	-> null

	case2:		p		q		-> root

	case3: 		p/q		null	-> p/q

	case4:		root is p or q  -> root


	  1
	/	\

	2	3

	/\
    4 5


    p = 4	q = 3

    1:

    	2:
    		4:	return 4
    		5:	return null

    	return 4

    	3:	return 3

    return 1



    p = 4	q = 2

    1:
    	2:
    		return 2

    	3:
    		return null
    		
    return 2

*/


public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	
	if(root == null){
		return null;
	}

	// case 4
	if(root == p || root == q){
		return root;
	}

	TreeNode left = lowestCommonAncestor(root.left, p, q);
	TreeNode right = lowestCommonAncestor(root.right, p, q);

	// case 1
	if(left == null && right == null){
		return null;
	}

	// case 3
	if(left == null){
		return right;
	}

	if(right == null){
		return left;
	}

	// both are not null, case 2
	return root;
}
