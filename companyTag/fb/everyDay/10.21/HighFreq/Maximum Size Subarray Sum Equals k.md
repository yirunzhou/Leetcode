Maximum Size Subarray Sum Equals k.md




```
/**
	input : nums array, sum < I.max, may have negative
	output : max length of subarray with sum == k, if there isnt, return 0

	presum with hash
	hash - presum -> end index of the presum
	init with (0 -> -1)
*/


class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        Map<Integer, Integer> presumIndex = new HashMap<>();

        // sum[0, i] -> i

        // init with 0 -> -1, make sure if a sum[0, i] == k, then we have answer

        presumIndex.put(0, -1);

      	int max = 0;

      	int sum = 0;

      	for(int i = 0; i < nums.length; i ++){
      		sum += nums[i];

      		// sum - preSum = k
      		// preSum = sum - k

      		int toFind = sum - k;

      		if(presumIndex.containsKey(sum - k)){
      			int curLen = i - presumIndex.get(sum - k);
      			max = Math.max(max, curLen);
      		}

      		if(!presumIndex.containsKey(sum)){
      			presumIndex.put(sum, i);
      		}
      	}

      	return max;
    }
}


/**
	input : nums array, sum < I.max, all POSITIVE
	output : max length of subarray with sum == k, if there isnt, return 0

	two pointers
*/

/**
	target = 7

	if [i, j] is larger -> stop moving j, as moving j will only get larger

	i++, does j need to move down to i? 
	no, as previous loop [i, j-1] is < k, if move down j, will only get smaller sum

	
					j
			i
		4	2	3	2	5

	ans = 3

*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {

    	int max = 0;

    	int lo = 0;
    	int hi = 0;

    	int sum = 0;

    	for(; lo < nums.length; lo ++){

    		while(hi < nums.length && sum < k){
    			sum += nums[hi];
    			hi ++;
    		}

    		if(sum == k){
    			max = Math.max(max, hi - lo);
    		}

    		sum -= nums[lo];
    	}

    	return max;
	}
}



```