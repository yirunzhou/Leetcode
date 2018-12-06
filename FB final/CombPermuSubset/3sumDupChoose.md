3sumDupChoose.md


```


public List<List<Integer>> threeSum(int[] nums){

	List<List<Integer>> result = new ArrayList<>();

	Arrays.sort(nums);

	for(int i = 0; i < nums.length; i++){

		if(i != 0 && nums[i] == nums[i-1]){
			continue;
		}

		int lo = i;
		int hi = nums.length-1;

		while(lo <= hi){

			int sum = nums[i] + nums[lo] + nums[hi];

			if(sum == 0){
				result.add(new ArrayList<Integer>(
					Arrays.asList(
						nums[i], nums[lo], nums[hi]
				)));

				while(lo+1 <= hi && nums[lo] == nums[lo+1]){
					lo ++;
				}

				while(lo+1 <= hi && nums[hi] == nums[hi-1]){
					hi --;
				}
				// move to the last one of duplication

				lo ++;
				hi --;

			} else if(sum > 0){

				hi --;

			} else {
				lo ++;
			}

		}

	}

	return result;

}

