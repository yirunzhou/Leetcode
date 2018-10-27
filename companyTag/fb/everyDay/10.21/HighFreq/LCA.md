
find path:

	when you do not find in root's left and right, return false


```

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
        input tree, p,q 
        output is LCA, or null when p or q is not in the tree
        
        1. in the tree?
        2. root to target path
        3. compare start from 0, to find the first diff
    
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        
        boolean pFound = findPath(pPath, root, p);
        boolean qFound = findPath(qPath, root, q);
        
        System.out.println(pPath);
        System.out.println(qPath);
        
        
        if(!pFound || !qFound){
            return null;
        }
        
        TreeNode LCA = root;
        
        for(int i = 0; i < Math.min(pPath.size(), qPath.size()); i ++){
            
            TreeNode curP = pPath.get(i);
            
            TreeNode curQ = qPath.get(i);
            
            if(curP == curQ){
                LCA = curP;
            }
            
        }
        
        return LCA;
    }
        
    // dfs to find the target, if we found, return true, else return false, backtrack the path
    
    private boolean findPath(List<TreeNode> path, TreeNode root, TreeNode target){
        
        if(root == null){
            return false;
        }
        
        if(root.val == target.val){
            path.add(root);
            return true;
        }
        
        
        path.add(root);
        
        if(!findPath(path, root.left, target) && !findPath(path, root.right, target)){
            
            path.remove(path.size()-1);
            
            return false;
            
        } else {
        	
        	return true;

        }
        
    }
}

```