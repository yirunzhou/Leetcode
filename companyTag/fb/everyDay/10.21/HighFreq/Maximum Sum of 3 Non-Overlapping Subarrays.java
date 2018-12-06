Maximum Sum of 3 Non-Overlapping Subarrays

Common Mistakes:

	PreSum calculation:

		preSum[i] -> is the sum of [0, i-1]

		mistake1 : i's range;
		mistake2 : what to add, nums[i] or nums[i-1];


```
		for(int i = 1; i <= nums.length; i ++){

			preSum[i] = preSum[i-1] + nums[i-1];

		}



```
Solution 2 mistakes:

	Index range claculation:

		use example, like k = 2 to calc, 

		HOWEVERE, real expression should use input val, not 2 in example!!!



	When return the Result Object, make sure we are returning the MAX and index of MAX



Solution 3 mistakes:



	Pass into aux function, the var's name is suggested to be the same as original function

	Update the rightMax or leftMax:

		1. meanwhile update global max

```	
		if(cur > max){
			max = cur; // MUST DO IT !!!!!
			...
		}

```

		2. update with previous value -> previous is i-1 in leftMax, but i+1 in rightMax
		3. rightMax[i+k], not i+k+1







1.Solution1: O(n^3)

 iterate over the starting index of left two arrays

 find the max thrid array with sliding window, or preSum

2.Solution2: O(n^2)

 iterate over the possible second array's position

 find the max first and third array with sliding window

3.Solution3: O(n)
	
 iterate over the possible second array's starting position, i

 preprocess the max subarray's starting index in range [0, j] and [j, len-1]

 as we know that we need to find the max subarray in range [0, i-1] and [i+k, len]

 thus we can use the preprocessed array

 the preprocess is O(n)



```
Solution1:

	k = 2

	t - [s+k, len-k]

	s - [f+k, len-2k]

	f - [0, len-3k]

	0	1	2	3	4	5	6	7


class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
   		
   		int[] preSum = getPreSum(nums);

   		int max = 0;

   		int[] result = new int[3];

   		int len = nums.length;

   		for(int f = 0; f <= len-3*k; f ++){

   			for(int s = f + 2; s <= len-2*k; s ++){

   				int fristSum = sum(f, f+k-1, preSum);
   				int secondSum = sum(s, s+k-1, preSum);

   				for(int t = s + 2; t <= len-k; t++){

   					int thirdSum = sum(t, t+k-1, preSum);

   					int total = fristSum + secondSum + thridSum;

   					if(total > max){
   						result[0] = f;
   						result[1] = s;
   						result[2] = t;
   						max = total;
   					}
   				}
   			}
   		}

   		return result;
    }


    // previous i numbers's sum -> [0, i-1]
    private int[] getPreSum(int[] nums){
    	int[] preSum = new int[nums.length+1];

    	for(int i = 1; i <= nums.length; i ++){
    		preSum[i] = preSum[i-1] + nums[i-1];
    	}

    	return preSum;
    }

    private int getSum(int start, int end, int[] preSum){
    	return preSum[end+1] - preSum[start];
    }
}

```

```
Solution2:

class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

    	// iterate over the second array's start
    	// if k = 2 -> [k, len-2*k]
    	//				i
    	// 	0	1	2	3	4	5	6	7	

    	int[] preSum = preSum(nums);

    	int max = 0;

    	int[] result = new int[3];

    	int len = nums.length;

    	for(int i = k; i <= len-2*k; i ++){

    		Result getMaxLeft = helper(nums, k, 0, i-1);

    		Result getMaxRight = helper(nums, k, i+k, len-1);

    		int total = getMaxLeft.sum + getMaxRight.sum + sum(i, i+k-1, preSum);

    		if(total > max){
    			max = total;
    			result[0] = getMaxLeft.index;
    			result[1] = i;
    			result[2] = getMaxRight.index;
    		}

    	}

    	return result;
    }

    // return the stating index and sum of the max subarray in range[start, end]
    
	public Result helper(int[] nums, int k, int start, int end){

		int sum = 0;

		for(int i = start; i <= start+k-1; i ++){
			sum += nums[i];
		}

		int max = sum;
		int index = start;

		int lo = start + 1;
		int hi = lo + k - 1;

		while(hi <= end){

			// get current sum
			sum += nums[hi];
			sum -= nums[lo-1];

			if(sum > max){
				max = sum;
				index = lo;
			}

			lo ++;
			hi ++;
		}

		return new Result(max, index);

	}

    private class Result{
    	int sum;
    	int index;

    	public Result(int s, int i){
    		sum = s;
    		index = i;
    	}
    }

    private int[] preSum(int[] nums){
    	int[] preSum = new int[nums.length+1];

    	for(int i = 1; i <= nums.length; i ++){
    		preSum[i] = preSum[i-1] + nums[i-1];
    	}

    	return preSum;
    }

    private int sum(int start, int end, int[] preSum){
    	return preSum[end+1] - preSum[start];
    }
}


Solution3:

```


public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    
    
    // iterating over the possible second array's starting index -> i
    
    // find out the start of max subarray in the range of [0, i-1], [i+k, len-1], record in int[] leftMax, rightMax
    
    /**
        so first preprocess to get LeftMax, rightMax
        
        then iterate i
        
        -> O(n)
    */
    
    // init
    int[] result = new int[3];
    
    int maxSum = 0;
    
    int[] preSum = preSum(nums);
    
    int[] leftMax = leftMax(nums, k, preSum);
    
    int[] rightMax = rightMax(nums, k, preSum);
    
    // iterate
    
    /**
            if k = 2
            
            [k, len -k]
                           i
            0    1    2    3    4    5    6
    
    */
    
    int len = nums.length;
    
    for(int i = k; i <= len-2*k; i++){
    
        int l = leftMax[i-1];
        
        int r = rightMax[i+k+1];
        
        int curSum = sum(l, l+k-1, preSum) + sum(i, i+k-1, preSum) + sum(r, r+k-1, preSum);
        
        // update result 
        if(curSum > maxSum){
            maxSum = curSum;
            result[0] = l;
            result[1] = i;
            result[2] = r;
        }
        
    }
    
    return result;
}

// preSum, sum,  leftMax,  rightMax

// return the start index array of max sum subarray in range of [0, i]
private int[] leftMax(int[] nums, int k, int[] preSum){
    
	int len = nums.length;

    int[] leftMax = new int[nums.length];
    
    int max = sum(0, k-1, preSum);
    
    
    // iterate over the end
    /**
        if k = 2
        
        
                  i
        0    1    2    3    4    5
    
        if cur <= max, then 
        leftMost[i] = leftMost[i-1]
        
        else 
        leftMost[i] = cur start = 
    
    */
    for(int i = k; i < len; i++){
        
        int cur = sum(i-k+1, i, preSum);
        
        if(cur > max){
        	max = cur;
            leftMax[i] = i - k +1;
        } else {
            leftMax[i] = leftMax[i-1];
        }
    }

    
    return leftMax;
}


private int[] rightMax(int[] nums, int k, int[] preSum){
    
	int len = nums.length;

    int[] rightMax = new int[nums.length];
    
    int max = sum(len-k, len-1, preSum);
    
    // iterate over its start, [0, len-k]
    
    
    for(int i = len-k; i >= 0; i --){
        
        int cur = sum(i, i+k-1, preSum);
        
        if(cur >= max){
            max = cur;
            rightMax[i] = i;
        } else{
            
            rightMax[i] = rightMax[i+1];
        
        }
    
    }
    
    return rightMax;

}



private int[] preSum(int[] nums){
    
    // preSum[i] -> 0 to ith sum -> [0,i-1]
    
    int[] preSum = new int[nums.length+1];
    
    preSum[0] = 0;
    
    for(int i = 1; i <= nums.length; i ++){
    
        // is previous preSum + i-1
        preSum[i] = preSum[i-1] + nums[i-1];
        
    }
    
    return preSum;

}


private int sum(int start, int end, int[] preSum){

    return preSum[end+1] - preSum[start];

}





```




