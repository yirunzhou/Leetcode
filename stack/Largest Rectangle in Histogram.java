Largest Rectangle in Histogram.java


class Solution {
    public int largestRectangleArea(int[] heights) {
        /**
            maintain an ascending stack,
            the previous one of the elem in the stack is the left boundary's index
        */
        
        Stack<Integer> stack = new Stack<>();
        
        int max = 0;
        
        /**
            (leftBound, rightBound)
        */
        
        for(int i = 0; i < heights.length; i ++){
            
            // get all of the index with rightBound as current index out
            int rb = i;
            
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int cur = stack.pop();
                int lb = stack.isEmpty()? -1 : stack.peek();
                max = Math.max(max, heights[cur] * (rb - lb-1));
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            
            int rb = heights.length;
            int cur = stack.pop();
            int lb = stack.isEmpty() ? -1 : stack.peek();
            
            max = Math.max(max, heights[cur]*(rb-lb-1));
        }
        
        return max;
    }
}