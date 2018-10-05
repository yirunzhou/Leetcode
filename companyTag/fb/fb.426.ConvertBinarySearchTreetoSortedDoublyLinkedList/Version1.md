```
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
 
     2
    /\
    1 3
    


    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }

        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);

        root.left = root;
        root.right= root;

        
        
        return connect(connect(left, root), right);
    }


    // 1. connect leftTail to rightHead
    // 2. connect leftHead to rightTail
    pirvate Node connect(Node left, Node right){
        // corner cases
        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }



        Node rightTail = right.left;
        Node leftTail = left.left;

        // 1.

        leftTail.right = right;
        right.left = leftTail;


        // 2.

        left.left = rightTail;
        rightTail.right = left;

        return left;
    }
}