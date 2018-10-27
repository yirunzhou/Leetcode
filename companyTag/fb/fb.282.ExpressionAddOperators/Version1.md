

```
public List<String> addOperators(String num, int target) {
        
	List<String> result = new ArrayList<>();

	helper(result, num, "", target, 0, 0, 0);

	return result;
}


private void helper(List<String> result, String num, String path, int target, int pos, long eval, long multied){

	// pos - start from pos, to pick next number
	// path - exisiting exp
	// eval - eval of existing exp
	// multied - if we choose *, then eval = eval - muilted + multied * cur


	// exisit

	if(pos == num.length()){
		if(eval == target){
			result.add(path);
		}
		return;
	}


	for(int i = pos; i < nums.length(); i ++){

		// meet leading 0
		
		if(i != pos && nums.charAt(pos) == '0'){
			return;
		}

		// choose num[pos, i]

		long cur = Long.valueOf(num.substring(pos, i+1));

		if(pos == 0){

			helper(result, num, "" + cur, target, i+1, cur, cur);

		} else{

			helper(result, num, path + "+" + cur, target, i+1, eval + cur, cur);

			helper(result, num, path + "-" + cur, target, i+1, eval - cur, -cur);

			helper(result, num, path + "*" + cur, target, i+1, eval - multid + multied * cur, 

			multied * cur);

		}
	}
}