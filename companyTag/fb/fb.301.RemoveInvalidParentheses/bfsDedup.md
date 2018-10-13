
**bfs NO need to pass in Starting index, only the elements in queue that matters**

```


public List<String> removeInvalidParentheses(String s) {

	List<String> result = new ArrayList<>();

	bfs(result, s);

	return result;
}


private void bfs(List<String> result, String s){

	Set<String> visited = new HashSet<>();
	Queue<StringBuilder> queue = new LinkedList<>();

	queue.offer(new StringBuilder(s));
	visited.add(s);

	while(!queue.isEmpty()){

		int size = queue.size();
		boolean found = false;

		while(size-- > 0){
			StringBuilder cur = queue.poll();

			if(isValid(cur)){
				found = true;
				result.add(cur.toString());
			}

			for(int i = 0; i < cur.length(); i ++){

				StringBuilder copy = new StringBuilder(cur);

				copy.deleteCharAt(i);

				if(visited.add(copy.toString())){
					queue.offer(copy);
				}
			}
		}

		if(found){
			break;
		}
	}
}

private boolean isValid(StringBuilder sb){
	int count = 0;

	for(int i = 0; i < sb.length(); i ++){
		if(sb.charAt(i) == '('){
			counter ++;
		} else if (sb.charAt(i) == ')'){
			counter --;
			if(counter < 0){
				return false;
			}
		}
	}

	return counter == 0;
}
