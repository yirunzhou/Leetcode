

DFS and backtracking, add to result when it is the leave


Mistakes:


	1. Define a backtrack() to restore the `path` builder when return

	2. Be consistent, outer function should just call helper(root, ...), the logic is handled inside helper:

		Meaning of a paticular function is to append 'val->' to path

		Or, when it is the leave node, just append 'val'

		When you append path outside helper, when it was a 1 root tree, then we didn't add anything


	3. string backtrack should be careful, the appened value of a variable may not be 1, so use defined backtrack()


	4. Test!! empty tree, one node


```
	

class Solution {
    
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        StringBuilder path = new StringBuilder();
        
        List<String> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        helper(result, path, root);
        
        return result;
    }
    
    
    // append cur.val->, dfs backtrack
    
    private void helper(List<String> result, StringBuilder path, TreeNode root){
        
        if(root == null){
            return;
        }
        
        int oriLen = path.length();

        // add to result
        if(root.left == null && root.right == null){
            
            path.append(root.val);
            
            result.add(path.toString());
        
            backtrack(path, oriLen);

            return;
        }
        
        
        
        path.append(root.val);
        path.append("->");
        
        // call dfs call
        
        helper(result, path, root.left);
        
        helper(result, path, root.right);
        
        backtrack(path, oriLen);
    }
    
    
    private void backtrack(StringBuilder path, int oriLen){
        while(path.length() != oriLen){
            path.deleteCharAt(path.length()-1);
        }
    }
}


```







