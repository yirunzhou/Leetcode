Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.



Mistakes:
	

	0. Sliding window min length is only applicable when input is all positive
	1. found boolean should be false at first


```

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        int minLen = Integer.MAX_VALUE;
        
        int sum = 0;
        
        int lo = 0;
        int hi = 0;
        
        boolean found = false;
        
        for(; lo < nums.length; lo ++){
            
            while(hi < nums.length && sum < s){
                sum += nums[hi];
                hi ++;
            }
            
            if(sum >= s){
                found = true;
                minLen = Math.min(minLen, hi - lo);
            }
            
            sum -= nums[lo];
        }
        
        return found ? minLen : 0;
    }
}