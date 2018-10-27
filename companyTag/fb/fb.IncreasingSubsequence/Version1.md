```
Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]


```

```
	

	i		
	4	6	4	7	7	


demo:
level = 0


	4
		4	6
				4	6	7

		4	4
				4	4	7
		4	7
				4	7	7


	6
		6	7
				6	7	7	

	7	
		7	7


	7	


class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){

    	if(temp.size() > 1){
    		result.add(new ArrayList<Integer>(temp));
    	}


    	Set<Integer> set = new HashSet<>();


    	for(int i = start; i < nums.length; i ++){

    		if(set.contains(nums[i])){
    			continue;
    		}


    		if(temp.size() == 0 || temp.get(temp.size()-1) <= nums[i]){

    			set.add(nums[i]);

    			temp.add(nums[i]);

    			dfs(result, temp, nums, i + 1);

    			temp.remove(temp.size()-1);

    		}

    	}


    }

}