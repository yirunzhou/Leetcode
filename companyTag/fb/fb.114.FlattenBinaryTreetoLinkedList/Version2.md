
```
public void flatten(TreeNode root){
	helper(root);
}


// we return the tail of the flattened tree
public TreeNode helper(TreeNode root){
	// base
	if(root == null){
		return null;
	}

	// divide and conqure

	TreeNode leftTail = helper(root.left);
	TreeNode rightTail = helper(root.right);

	// null
	if(rightTail == null && leftTail == null){
		return root;
	}

	if(rightTail == null){
		root.right = root.left;
		root.left = null;
		return leftTail;
	}

	if(leftTail == null){
		return rightTail;
	}


	// assume left right are not null
	
	TreeNode rootRight = root.right;
	
	root.right = root.left;
	
	root.left = null;

	leftTail.right = rootRight;

	return rightTail;
}

