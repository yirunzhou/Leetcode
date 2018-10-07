Given a set of distinct integers, nums, return all possible subsets (the power set).


TIME: O(n\*2^n)
Space: same

```
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp, int level){
    	// exit
    	if(level == nums.length){
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}


    	// case1: add 

    	temp.add(nums[level]);
    	dfs(result, nums, temp, level +1);
    	temp.remove(temp.size()-1);


    	// case2: no add

    	dfs(result, nums, temp, level +1);
    }