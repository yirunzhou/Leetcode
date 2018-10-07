    Given a collection of distinct integers, return all possible permutations.

TIME: O(n\*n!)
SPACE : SAME

```
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();

       dfs(result, nums, new ArrayList<>());

       return result;
    }


    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp){
    	// exit
    	if(temp.size() == nums.length){
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}

    	//

    	for(int i = 0; i < nums.length; i ++){
    		if(temp.contains(nums[i])){
    			continue;
    		}
    		temp.add(nums[i]);
    		dfs(result, nums, temp);
    		temp.remove(temp.size()-1);
    	}
    }


```


Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Time: O(n \* n!)
Space : same


```
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        dfs(result, nums, new ArrayList<Integer>(), visited);

        return result;

    }

    private void dfs(List<List<Integer>> result, 
    	int[] nums, 
    	List<Integer> temp, 
    	boolean[] visited){


    	// exit
    	if(temp.size() == nums.length){
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}

    	// dfs

    	for(int i = 0; i < nums.length; i ++){
    		if(visited[i] || 
    		  (i!=0 && nums[i] == nums[i-1] && !visited[i-1])){
    		  	continue;
    		}

    		visited[i] = true;
    		temp.add(nums[i]);
    		dfs(result, nums, temp, visited);
    		temp.remove(temp.size()-1);
    		visited[i] = false;
    	}


    }