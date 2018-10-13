Dedup:

    1. first element
    2. second element
    3. thrid element

    be sure to be aware of how to dedup each element


Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.


Time : O(n2)
Space

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
```

Map
```
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i ++){

            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }


            Set<Integer> set = new HashSet<>();

            for(int j = i + 1; j < nums.length; j ++){

                if(set.contains(-nums[i] - nums[j])){
                    result.add(new ArrayList<Integer>(Arrays.asList(
                        nums[i], nums[j], 0-nums[i] - nums[j])));

                    while(j < nums.length-1 && nums[j] == nums[j+1]){
                        j ++;
                    }
                }

                set.add(nums[j]);
            }
        }

        return result;
    }


    