

if(i != start + 1 && nums[i] == nums[i-1]){

			continue;
			
}

This can only be used in same level dedup,

But when doing two sum, we can choose same number twice, as they are NOT in the same level


```

-1 -1 -1 2 2 3



public List<List<Integer>> threeSum(int[] nums) {

	Arrays.sort(nums);

	List<List<Integer>> result = new ArrayList<>();


	for(int i = 0; i < nums.length; i ++){

		if(i != 0 && nums[i] == nums[i-1]){
			continue;
		}

		findUniqueTwoSum(result, i, nums);
	}

	return result;

}


private void findUniqueTwoSum(List<List<Integer>> result, int start, int[] nums){

	Set<Integer> set = new HashSet<>();

	int target = 0 - nums[start];

	for(int i = start + 1; i < nums.length; i ++){




		if(set.contains(target - nums[i])){

			result.add(new ArrayList<Integer>(nums[start], target-nums[i], nums[i]));

		}

		set.put(nums[i]);

	}

}
