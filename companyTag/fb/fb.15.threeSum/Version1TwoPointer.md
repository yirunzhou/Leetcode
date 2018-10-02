

public List<List<Integer>> threeSum(int[] nums){
	List<List<Integer>> res = new ArrayList<>();
	if(nums == null || nums.length < 3){
		return res;
	}

	for(int i = 0; i < nums.length; i ++){

		// skip the rest of duplication
		if(i != 0 && nums[i] == nums[i-1]){
			continue;
		}

		int lo = i + 1;
		int hi = nums.length-1;
		while(lo < hi){
			int sum = nums[i] + nums[lo] + nums[hi];
			if(sum == 0){
				//add into result
				res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lo], nums[hi])));
				//skip the lo and hi's dup
				lo = skipLoDup(nums, lo);
				hi = skipHiDup(nums, hi);
				lo ++;
				hi --;
			} else {
				if(sum > lo){
					hi = skipHiDup(nums, hi);
					hi --;
				} else {
					lo = skipLoDup(nums, lo);
					lo ++;
				}
			}
		}
	}

	return res;
}

private int skipLoDup(int[] nums, int lo){
	while(lo < nums.length && nums[lo] == nums[lo+1]){
		lo++;
	}
	return lo;
}

private int skipHiDup(int[] nums, int hi){
	while(hi > 0 && nums[hi] == nums[hi-1]){
		hi--;
	}
	return hi;
}
}