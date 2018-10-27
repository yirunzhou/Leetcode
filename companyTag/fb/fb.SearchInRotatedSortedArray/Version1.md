
```

public boolean search(int[] nums, int target){
	
	int lo = 0;
	int hi = nums.length;

	while(lo <= hi){

		int mid = lo + (hi-lo) /2;

		if(nums[mid] == target){
			return true;
		}


		/**
				0	1	2	3	4	5	6
				5	6	7	2	2	0	3



				nums[mid] < nums[hi], nums[mid] != nums[lo]
					right is sorted?

					if right part no sorted
					case1: 
						nums[lo] < nums[mid]

						not possible

					case2: nums[lo] > nums[mid]

						nums[lo] > nums[mid]

						no possible

		*/

		if(nums[lo] == nums[mid] && nums[mid] == nums[hi]){
			lo ++;
			hi --;
			continue;
		}


		if(nums[mid] < nums[hi]){
			// right part is sorted

			if(nums[mid] < target && target <= nums[hi]){
				// in range of right
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		} else {

			if(nums[lo] <= target && target < nums[mid]){
				hi = mid -1;
			} else {
				lo = mid + 1;
			}

		}
	}

	return false;
}


