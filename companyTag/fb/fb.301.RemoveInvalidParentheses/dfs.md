
**Explicit is better than implicit**

* when current is valid:
	* res is Empty -> add
	* res[0] is the same length -> add
	* res[0]'s length is shorter -> clear and add
	* res[0]'s length is longer -> do nothing
 

```
class Solution {

public List<String> removeInvalidParentheses(String s) {
	List<String> res = new ArrayList<>();
    
    if(s == null){
        return res;
    }
    
    Set<String> visited = new HashSet<>();

    dfs(res, s, new StringBuilder(), 0, 0, 0, visited);

	return res;
}

private void dfs(List<String> res, String s, StringBuilder current, int left, int right, int level){
	// base

	if(level == s.length()){
		if(left == right){
			if(res.size() == 0){
				res.add(current.toString());
			} else if(res.get(0).length() == current.length()){
				res.add(current.toString());
			} else if(res.get(0).length() < current.length()){
				res.clear();
				res.add(current.toString());
			}
		}
		return;
	}


	// recu
	// CASE1: ADD

	if(canAdd(current, s.charAt(level), left, right, visited)){

		current.append(s.charAt(level));
		visited.add(current);

		if(s.charAt(level) == '('){
			dfs(res, s, current, left + 1, right, level + 1, visited);
		} else if(s.charAt(level) == ')'){
			dfs(res, s, current, left, right + 1, level + 1, visited);
		} else {
			dfs(res, s, current, left, right, level + 1, visited);
		}

		current.deleteCharAt(current.length()-1);
	}


	// CASE2: NOT ADD

	if(s.charAt(level) != '(' && s.charAt(level) != ')'){
		return;// normal char should not be not added
	}

	dfs(res, s, current, left, right, level + 1, visited);

}


private boolean canAdd(StringBuilder sb, char c, int left, int right, Set<String> visited){
	if(c != ')' && c != '('){
		return true;
	}

	if(c == ')'){
		if(left <= right){
			return false;
		}
	}

	sb.append(c);
	
	boolean canAdd = true;
	
	if(visited.contains(sb.toString())){
		canAdd = false;
	}

	sb.deleteCharAt(sb.length()-1);

	return canAdd;
}