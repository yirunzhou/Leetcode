import java.util.*;


public class HTMLToTree{


	/**
		return the startIndex's tree structure, and its children's end index+1

		assume the index is valid
		
						i
		<html>	<head><head> <body><title>	<title><body>	<html>
		



	*/

	public TreeNode stringToTree(String html){

		String[] list = toStringList(html);

		return listToTree(list, 0).content;
	}



	public Result listToTree(String[] list, int startIndex){


		String label = list[startIndex];

		TreeNode curNode = new TreeNode(label);

		int curIndex = startIndex + 1;

		/**
			html0
			head1
			head2
			body3
			title4
			title5
			body6
			html7

		*/

		for(; curIndex < list.length; curIndex ++){

			if(!list[curIndex].equals(label)){

				// get child and index

				System.out.printf("Label not end of %s, get its child from %d\n", label, curIndex);

				Result result = listToTree(list, curIndex);

				curIndex = result.index;

				curNode.children.add(result.content);

			} else {

				break;

			}

		}
		
		return new Result(curNode, curIndex);

	}

	private class Result{

		public TreeNode content;

		public int index;

		public Result(TreeNode node,  int i){
			content = node;
			index = i;
		}

	}


	private String[] toStringList(String html){

		List<String> result = new ArrayList<>();

		for(int i = 0; i < html.length(); i ++){

			if(html.charAt(i) == '<'){

				// start to get label 

				StringBuilder label = new StringBuilder();

				while(i +1 < html.length() && html.charAt(i+1) != '>'){
					label.append(html.charAt(i+1));
					i ++;
				}
				// i is the last valid char of the label

				result.add(label.toString());

			}

		}

		String[] array = new String[result.size()];

		for(int i = 0; i < array.length; i ++){
			array[i] = result.get(i);
		}

		return array;
	}



	public static void main(String[] args) {

		HTMLToTree test = new HTMLToTree();

		String html = "<html><head><head><body><title><title><body><html>";

		for(String str : test.toStringList(html)){

			System.out.println(str);

		}

		TreeNode root = test.stringToTree(html);
		
		System.out.println(test.preorder(root));


	}

	public List<String> preorder(TreeNode root){

		List<String> result = new ArrayList<>();

		helper(root, result);

		return result;
	}

	private void helper(TreeNode root, List<String> result){

		if(root == null){
			return;
		}

		result.add(root.label);

		for(TreeNode child : root.children){

			helper(child, result);
		}

	}


	private class TreeNode{

		public String label;

		public List<TreeNode> children;

		public TreeNode(String l){
			
			label = l;

			children = new ArrayList<>();

		}
 	}

}