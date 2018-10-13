```

    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	Arrays.sort(nums);

    	for(int i = 0; i < nums.length; i ++){
    		if(i != 0 && nums[i] == nums[i-1]){
    			continue;
    		}

    		Set<Integer> hash = new HashSet<>();

    		for(int j = i+1; j < nums.length; j ++){
    			int target = 0 - nums[i] - nums[j];
    			if(hash.contains(target)){
    				result.add(
    					new ArrayList<Integer>(Arrays.asList(nums[i], target, nums[j]))
    				);

    				j = skipJ(nums, j);
    			}
    			hash.add(nums[j]);
    		}
    	}

    	return result;
    }


    private int skipJ(int[] nums, int j){
    	while(j+1 < nums.length && nums[j] == nums[j+1]){
    		j ++;
    	}
    	return j;
    }