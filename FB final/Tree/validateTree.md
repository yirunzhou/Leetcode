


```
public TreeNode testing(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> list = new ArrayList<>();
        
        inorder(root, list);
        
        TreeNode test = new TreeNode(0);
        
        test.left = root;
        
        test.right = test;
        
        list.add(test);
        
                
        boolean result = validateTree(list);
        
    
        System.out.printf("Validate result: %s \n", result + "");
        
        return null;
        
    }
    
    private boolean validateTree(List<TreeNode> list){
        
        Map<TreeNode, Integer> indegree = new HashMap<>();
        
        for(TreeNode node : list){
            
            if(!indegree.containsKey(node)){
                indegree.put(node, 0);
            }
            
            if(node.left != null){
                
                indegree.put(node.left, indegree.getOrDefault(node.left, 0) + 1);
                
            }
            
            if(node.right != null){
                
                indegree.put(node.right, indegree.getOrDefault(node.right, 0) + 1);
                
            }
            
        }
        
        int rootCnt = 0;
        
        for(int ind : indegree.values()){
            
            if(ind == 0){
                rootCnt ++;
            }
            
            if(ind >= 2){
                System.out.println("Indegree error");
                return false;
            }
            
            if(rootCnt > 1){
                System.out.println("Multi root");
                return false;
            }
            
        }
        
        if(rootCnt == 0){
            System.out.println("No root");
            return false;
        }
        
        return true;
    }
    
    
    private void inorder(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        
        inorder(root.left, list);
        
        list.add(root);
        
        inorder(root.right, list);
    }
}

```