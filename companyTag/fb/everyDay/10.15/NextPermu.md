```


public void nextPermutation(int[] nums) {


	int lo = nums.length-2;

	while(lo >= 0 && nums[lo] >= nums[lo+1]){
		lo --;
	}

	if(lo == -1){
		reverse(nums, 0, nums.length-1);
		return;
	}

	int hi = lo + 1;

	while(hi < nums.length && nums[hi] > nums[lo]){
		hi ++;
	}

	swap(nums, lo, hi -1);

	reverse(nums, lo + 1, nums.length-1);

}


private void swap(int[] nums, int lo, int hi){

	int t = nums[lo];

	nums[lo] = nums[hi];

	nums[hi] = t;
}

private void reverse(int[] nums, int lo, int hi){

	while(lo < hi){
		swap(nums, lo, hi);
		lo ++;
		hi --;
	}

}