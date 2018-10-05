```
public void flatten(TreeNode root) {
	flattenAndReturnBottom(root);
}


private TreeNode flattenAndReturnBottom(TreeNode root){
	if(root == null){
		return null;
	}    

	TreeNode leftTail = flattenAndReturnBottom(root.left);
	TreeNode rightTail = flattenAndReturnBottom(root.right);

	if(leftTail == null && rightTail == null){
		return root;
	}

	if(leftTail == null){
		return rightTail;
	}

	if(rightTail == null){
		root.right = root.left;

		root.left = null;      //CATCH !!!!!

		return leftTail;
	}

	// both left and right are not null
	TreeNode rootRight = root.right;

	root.right = root.left;

	root.left = null;

	leftTail.right = rootRight; 	//CATCH !!!!!

	return rightTail;
}

