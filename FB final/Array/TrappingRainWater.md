


		


	Mistakes:

		Meaning of the pointer:

			[0, left) (right, len-1] is accumulated
        

		acc += wall - current



```


class Solution {
    public int trap(int[] height) {
        
        if(height.length == 0){
            return  0;
        }
        
        int wall = Math.min(height[0], height[height.length-1]);
        
        int left = 0;
        int right = height.length-1;
        
        /**
            [0, left) (right, len-1] is accumulated
        
        */
        
        int acc = 0;
        
        while(left <= right){
            
            if(height[left] < height[right]){
                
                if(height[left] < wall){
                    
                    acc += wall - height[left];
                    
                } else {
                    
                    wall = Math.min(height[left],height[right]);
                    
                }
                
                left ++;
                
            } else {
                
                if(height[right] < wall){
                    
                    acc += wall - height[right];
                    
                } else {
                    
                    wall = Math.min(height[left], height[right]);
                    
                }
                
                right --;
                
            }
        }
        
        return acc;
    }
}