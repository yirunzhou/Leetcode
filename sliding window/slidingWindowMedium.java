

/**
	Mistakes:

	1. Window's length is k -> max start index is len-k -> number of windows is len-k+1
		
	2. When want to use contains -> override equals(Object o) | compareTo(Object o)
		
	3. When want to put into data structure in order: 
		1. natural ordder
			-> implements Comparable -> override compareTo(Object o)
		2. comparator


	Mistakes in comparaTo(Object o)
		
		integer compare -> overflow
*/


class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        /**
            Window position                Median
            ---------------               -----
            [1  3  -1] -3  5  3  6  7       1
             1 [3  -1  -3] 5  3  6  7       -1
             1  3 [-1  -3  5] 3  6  7       -1
             1  3  -1 [-3  5  3] 6  7       3
             1  3  -1  -3 [5  3  6] 7       5
             1  3  -1  -3  5 [3  6  7]      6
                              i
             
                                len - k +1
            
        left -> max heap
        right-> min heap
        
        add ->
            add to right -> adjust
                
        delete -> 
            see where it contains?
            delete from left
            delete from right
            adjust

        get medium ->
        left + right is odd-> then it is bigger.min or max
        left + right is even -> then it is ave of right.min + left.max
            
        */
        
        double[] result = new double[nums.length-k+1];
        
        TreeSet<Node> left = new TreeSet<>();
        TreeSet<Node> right = new TreeSet<>();
        
        for(int i = 0; i < k; i ++){
            add(left, right, new Node(nums[i], i));
        }
        
        for(int i = 0; i < result.length; i ++){
            result[i] = getMedium(left, right);
            if(i == result.length-1) break;
            delete(left, right, new Node(nums[i], i));
            add(left, right, new Node(nums[i+k], i+k));
        }
        
        
        return result;
        
    }
    
    private double getMedium(TreeSet<Node> left, TreeSet<Node> right){
        if(left.size() == right.size()){
            return  (0.5 * left.last().val + 0.5 * right.first().val);
        } else {
            if(left.size() > right.size()){
                return 1.0 * left.last().val;
            } else {
                return 1.0 * right.first().val;
            }
        }
    }
    
    private void add(TreeSet<Node> left, TreeSet<Node> right, Node node){
        left.add(node);
        adjust(left, right);
    }
    
    private void delete(TreeSet<Node> left, TreeSet<Node> right, Node node){
        if(left.contains(node)){
            left.remove(node);
        } else {
            right.remove(node);
        }
        adjust(left, right);
    }
    
    
    // after add or delete, the left and right should maintain balanced
    private void adjust(TreeSet<Node> left, TreeSet<Node> right){
        
        if(left.size() > 0 && right.size() > 0 && left.last().val > right.first().val){
            // swap
            Node l = left.pollLast();
            Node r = right.pollFirst();
            right.add(l);
            left.add(r);
        }
        
        if(Math.abs(left.size() - right.size()) > 1){
            if(left.size() > right.size()){
                right.add(left.pollLast());
            } else {
                left.add(right.pollFirst());
            }
        }
        
    }
    
        
    
    private class Node implements Comparable{
        
        int val;
        int index;
        
        public Node(int v, int i){
            val = v;
            index = i;
        }
        
        // first compare with 
        public int compareTo(Object o){
            Node n = (Node)o;
            if(n.val == this.val){
                return this.index - n.index;
            }
            else if(this.val > n.val){
                return 1;
            } else return -1;
        }
        
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            
            if(!(o instanceof Node)){
                return false;
            }
            
            Node node = (Node)o;
            return this.compareTo(node) == 0;
        }
        
    }
    
    
}