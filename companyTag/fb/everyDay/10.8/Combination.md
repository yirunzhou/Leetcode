**CATCH1 : remove should pass in the index of the removed element**
**CATCH2 : EXIT CONDITION not only target == 0, but also target < 0, otherwise no terminate**

```

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.


    public List<List<Integer>> combine(int n, int k) {
        

    }



```


Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.



```
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        dfs(result, candidates, new ArrayList<Integer>(), target, 0);

        return result;
    
    }


    private void dfs(List<List<Integer>> result, int[] candidates, List<Integer> temp, int target, int start){

        // exit
        if(target == 0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        // [start, end]

        // 1 | 1 1 2 3  
        // start = 1
        // t = 4

        for(int i = start; i < candidates.length; i ++){
            if(i != start && nums[i] == nums[i-1]){
                continue;
            }
            if(candidates[i] > target){
                return;
            }
            temp.add(candidates[i]);
            dfs(result, candidates, temp, target - candidates[i], i + 1);
            temp.remove(temp.size()-1);
        }



    }