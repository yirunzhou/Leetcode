
	public List<List<Integer>> threeSum(int[] nums){
		if(nums == null || nums.length < 3){
			return res;
		}

		for(int i = 0; i < nums.length; i ++){
			if(i != 0 && nums[i] == nums[i-1]){
				continue;
			}

			// find unique two sum of -nums[i] start from i+1
			findUniqueTwoSum(res, nums, -nums[i], i+1);
		}

		return res;
	}

	private void findUniqueTwoSum(List<List<Integer>> res, int[] nums, int target, int start){
		// objective: find all unique (A, B) pair sum is target
		// 2. find if there is a match in the set
		// 		if there is, add, skip the same (make B unique)
		// 3. add current into the set

		Set<Integer> set = new HashSet<>();

		for(int i = 0; i < nums.length; i ++){
			int current = nums[i];
			int toFind = target - nums[i];

			// 2.
			if(set.contains(toFind)){
				//2.1
				res.add(new ArrayList<Integer>(Arrays.asList(-target, toFind, current)));
				//2.2
				i = skipDup(nums, i);
			}

			// 3.(1)
			set.add(nums[i]);
		}
	}

	private int skipDup(int[] nums, int i){
		if(i == nums.length -1){
			return i;
		}
		while(nums[i] == nums[i+1]){
			i++;
		}
		return i;
	}
