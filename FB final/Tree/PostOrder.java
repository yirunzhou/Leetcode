

```

public class PostOrderIterator implements Iterator<Integer>{

	private Stack<TreeNode> stack;

	public PostOrderIterator(TreeNode root){

		stack = new Stack<>();

		pushToLeafPath(root);
	}

	@Override
	public boolean hasNext(){
		return !stack.isEmpty();
	}

	@Override
	public Integer next() throw NoSuchElementException{

		if(!hasNext()){
			throw new NoSuchElementException("Traversal already completed!");
		}

		TreeNode cur = stack.pop();

		int next = cur.val;

		if(!stack.isEmpty() && stack.peek().left == cur){

			pushToLeafPath(stack.peek().right);

		}
	}

	private void pushToLeafPath(TreeNode root){
		while(root != null){

			stack.push(root);

			if(root.left != null){
				root = root.left;
			} else {
				root = root.right;
			}

		}
	}


}