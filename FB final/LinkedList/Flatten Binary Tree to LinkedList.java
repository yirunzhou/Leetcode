Flatten Binary Tree to LinkedList





Mistakes:

	1. See the problem of tree and list, be sure about the type

	2. Do not forget to set the root.left to be null after flatten

	3. Four cases, seperatly deal with




```
/*
	flatten left, flatten right
	and then merge left, right to right

	so helper should return the tail of the flatten list
	
*/

public void flatten(TreeNode root){
	
	helper(root);

}


private TreeNode helper(TreeNode root){

	if(root == null){
		return null;
	}


	TreeNode leftTail = helper(root.left);

	TreeNode rightTail= helper(root.right);


	if(leftTail == null && rightTail == null){

		return root;

	} else if(leftTail == null){

		return rightTail;

	} else if(rightTail == null){

		root.right = root.left;

		root.left = null;

		return leftTail;

	} else {

		leftTail.right = root.right;

		root.right = root.left;

		root.left = null

		return rightTail;
	}

}
