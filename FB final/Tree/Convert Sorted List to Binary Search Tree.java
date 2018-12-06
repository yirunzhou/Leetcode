Convert Sorted List to Binary Search Tree.md



	Sorted -> Inorder traversal to construct

	but when inorder, when to stop?

	we need to know how deep I should go

	so first count for the list -> n


	construct n/2 nodes for the left

	construct 1 node for root

	construct n - n/2 - 1 for right



	base case is n == 0 return null


Mistakes :

	ListNode, TreeNode, different type!!!

		Declear, 

		Pass into function, 

		Return type, 

		Assignment, 

		Operation like . or call its method

	check for those one by one;




```


class Solution {
    /**
          i
        l1 -> l2 -> l3 -> l4 -> l5 -> l6
        
            
        
            
        inorder traversal to construct n/2 node for left, 1 node for root, n - n/2-1 node for right
    
    */
    
    private ListNode pointer = null;
    
    public TreeNode sortedListToBST(ListNode head) {
        
        int n = count(head);
        
        pointer = head;
        
        TreeNode root = construct(n);
        
        return root;
    }
    
    
    private TreeNode construct(int n){
        
        if(n == 0){
            return null;
        }
        
        TreeNode left = construct(n/2);
        
        TreeNode root = new TreeNode(pointer.val);
        
        pointer = pointer.next;
        
        TreeNode right = construct(n - n/2 - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
        
    }
    
    private int count(ListNode head){
        
        int n = 0;
        
        while(head != null){
            n ++;
            head = head.next;
        }
        
        return n;
    }
    
    
    
    
}


```












