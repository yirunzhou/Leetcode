


```

public Result getMaxSubarray(int[] nums, int start, int end, int k){

	int sum = 0;

	for(int i = start; i <= start + k -1; i ++){
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

	return new Result(max, start);

}