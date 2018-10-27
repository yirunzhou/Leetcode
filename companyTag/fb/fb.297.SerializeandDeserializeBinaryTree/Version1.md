


```

/**
		1
	/		\

	2		3
   / \ 		/ \

   4 5		  7

   
   	i	
queue   1	2	4	#	#	5	#	#	3	#	7

queue   										

	
		1
	/		\

	2		3
   / \ 		/ \

   4 5		  7




    how to recover:

    	input -> iterater	i

    	0. meet # 
    		poll
    		return null

    	1. create root
    		poll

    	2. create root.left recursively

    	3. create root.right rec..

    	4. return root




*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.

    private static final String EMPTY = "#";


    public String serialize(TreeNode root) {

    	StringBuilder result = new StringBuilder();

    	helper(result, root);

    	return result.toString();
        
    }


    private void helper(StringBuilder result, TreeNode root){
    	if(root == null){
    		result.append(EMPTY + " ");
    		return;
    	}

    	result.append("" + root.val + " ");

    	helper(result, root.left);
    	helper(result, root.right);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	String[] list = data.split(" ");

    	Queue<String> queue = new LinkedList<>();

    	for(String str : list){
    		queue.offer(str);
    	}

    	return helperDsr(queue);

    }

    private TreeNode helperDsr(Queue<String> queue){

    	if(queue.isEmpty()){
    		return null;
    	}

    	String cur = queue.poll();

    	if(cur.equals(EMPTY)){
    		return null;
    	}

    	TreeNode root = new TreeNode(Integer.valueOf(cur));

    	root.left = helperDsr(queue);

    	root.right = helperDsr(queue);

    	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

