

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.


```
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // choose the 1st A

        for(int i = 0; i < nums.length; i ++){
        	if(i != 0 && nums[i-1] == nums[i]){
        		continue;
        	}

        	int tareget = -nums[i];

        	// choose the 2, 3 -> -A = target

        	int lo = i+1; //CATCH
        	int hi = nums.length-1;

        	while(lo < hi){

	        	int sum = nums[lo] + nums[hi];

	        	if(sum == target){
	        		result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lo], nums[hi])));

	        		lo = skip(lo, nums);
	        		hi = skip(hi, nums);
	        	} else {
	        		if(sum > target){
	        			hi --;
	        		} else {
	        			lo ++;
	        		}
	        	}

	        }
        }

        return result;


    }


    private int skipLo(int[] nums, int lo, int hi){
    	while(lo < hi && nums[lo] == nums[lo+1]){
    		lo ++;
    	}
    	lo ++;
    	return lo;
    }

    private int skipHi(int[] nums, int lo, int hi){
    	while(lo < hi && nums[hi] == nums[hi-1]){
    		hi --;
    	}
    	hi --;
    	return hi;
    }



    