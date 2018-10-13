```


public List<List<Integer>> subsets(List<Integer> input){
	List<List<Integer>> result = new ArrayList<>();

	dfs(result, input, new ArrayList<Integer>(), 0);

	return result;
}

private void dfs(List<List<Integer>> result, List<Integer> input, List<Integer> temp, int level){
	if(level == input.size()){
		result.add(new ArrayList<Integer>(temp));
		return;
	}

	// add
	temp.add(input.get(level));
	dfs(result, input, temp, level +1);
	temp.remove(input.size()-1);

	// not add

	dfs(result, input, temp, level +1);
}