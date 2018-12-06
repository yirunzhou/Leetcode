



Given parenthesis, transform it to a tree stucture


```
private class TreeNode{
	
	public List<TreeNode> children;

	public TreeNode(){

		children = new ArrayList<>();

	}

	public void add(TreeNode t){

		children.add(t);

	}
}


public TreeNode transform(String input){

	if(input.length == 0){
		return null;
	}

	return helper(input, 1).content;

}


// return the Wrappper class , decode from startIndex

private Result helper(String input, int startIndex){

	TreeNode root = new TreeNode();
	
	int i = startIndex;

	for(; i < input.length(); i ++){

		char cur = input.charAt(i);

		if(cur == '('){

			Result subresult = (helper(input, i+1));

			root.add(subresult.content);

			i = subresult.endIndex;

		} else {

			break;

		}

	}

	return new Result(root, i);
	
}