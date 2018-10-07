**CATCH1 : remove should pass in the index of the removed element**


```

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, n, k, new ArrayList<Integer>(), 1);

        return result;
    }

    private void dfs(List<List<Integer>> result, int n, int k, List<Integer> comb, int start){
    	// exit
    	if(comb.size() == k){
    		result.add(new ArrayList<Integer>(comb));
    		return;
    	}


    	for(int i = start; i <= n; i ++){
    		comb.add(i);
    		dfs(result, n, k, comb, i+1);
    		comb.remove(comb.size()-1);	
    	}
    }



```


Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.



```
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

       	dfs(result, candidates, new ArrayList<Integer>(), target, 0);

       	return result;

    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp, int target, int start){
    	// exist
    	if(target < 0){
    		return;
    	}

    	if(target == 0){
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}

    	// dfs

    	for(int i = start; i < nums.length; i ++){
    		if(i != start && nums[i] == nums[i-1]){
    			continue;
    		}
    		if(nums[i] > target){
    			break;
    		}
    		temp.add(nums[i]);
    		dfs(result, nums, temp, target - nums[i], i + 1);
    		temp.remove(temp.size()-1);
    	}
    }