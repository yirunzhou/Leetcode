
**CATCH !!! WHAT TO RETURN WHEN WE MEET A DP PROBLEM????**

**NOT always dp[lastone]**


```
//  10 9 3 5 2 7 6 9
//  1. 1 1 2 1 3 3 4


class Solution {
    public int lengthOfLIS(int[] nums) {
    	// LIS that ends at i
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int maxLen = 1;

        for(int i = 1; i < nums.length; i ++){
        	for(int j = 0; j < i; j ++){
        		if(nums[j] < nums[i]){
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        			maxLen = Math.max(maxLen, dp[i]);
        		}
        	}
        }

        //return dp[nums.length-1]; // WRONG!!!!!!

        return maxLen;
    }
}