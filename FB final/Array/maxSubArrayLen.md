

Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
	


	Mistakes:

		1. input, output, be clear

		2. find equals k, then use hash

		3. use presum to calcu the length, be careful, len = endPoint - endPointOfPreSum



class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        
        // preSum[0, i] : i
        Map<Integer, Integer> preSum = new HashMap<>();
        
        preSum.put(0, -1);
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i ++){
            
            sum += nums[i];
            // sum - toFind = k
            // toFind = sum - k
            
            int toFind = sum - k;
            
            if(preSum.containsKey(toFind)){
                
                int curLen = i - preSum.get(toFind);
                
                maxLen = Math.max(maxLen, curLen);
                
            }
            
            if(!preSum.containsKey(sum)){
                preSum.put(sum, i);   
            }
            
        }
        
        return maxLen;
    }
}