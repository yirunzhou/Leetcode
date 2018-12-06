Serialize and Deserialize Binary Tree.md


Time: O()




Mistakes:

	0. Can ignore null input, just decode as "N,", split(",") will give a array with "N", de as a null

	1. Deserialize :

			after get the token, there are two cases, do no forget to check NULL

			is NULL

			is number

	2. preorder traverse the tree

	3. functions parameter pass into the helper, root? cur?, just use ROOT!!!!


```
	append
	helper(result, root.left)
	helper(result, root.right)

```




```

public class Codec {

    // Encodes a tree to a single string.
    
    private static final String SEP = ",";
    private static final String NULL = "N";
    
    public String serialize(TreeNode root) {
        
        // ?
        if(root == null){
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        helperSer(result, root);
        
        return result.toString();
    }
    
    // add cur val, or N if null
    // recursively
    private void helperSer(StringBuilder result, TreeNode cur){
        
        if(cur == null){
            
            result.append(NULL);
            result.append(SEP);
            
        } else{
            
            result.append(cur.val);
            result.append(SEP);
            
            helperSer(result, cur.left);
            helperSer(result, cur.right);
            
        }
        
    }
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.equals("")){
            return null;
        }
        
        String[] split = data.split(SEP);
        
        Queue<String> queue = new LinkedList<>();
        
        for(String str : split){
            queue.offer(str);
        }
        
        return helperDes(queue);
    }
    
    // access the peek, recursively call to get its left, right, append, return itself
    private TreeNode helperDes(Queue<String> queue){
        
        String peek = queue.poll();
        
        if(peek.equals(NULL)){
            return null;
        }
        
        // assume it is in 32-bits range
        TreeNode root = new TreeNode(Integer.valueOf(peek));
        
        root.left = helperDes(queue);
        root.right = helperDes(queue);
        
        return root;
    }
}
