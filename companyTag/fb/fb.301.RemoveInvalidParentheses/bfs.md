**The input might be valid, so where to judge peek is valid or not?**


```

class Solution {
public List<String> removeInvalidParentheses(String s) {
	List<String> res = new ArrayList<>();
    
    if(s == null){
        return res;
    }
    
	bfs(res, new StringBuilder(s));

	return res;
}

private void bfs(List<String> res, StringBuilder sb){

	Set<String> set = new HashSet<>();

	Queue<StringBuilder> queue = new LinkedList<>();
	
	queue.offer(sb);
	set.add(sb.toString());

	while(!queue.isEmpty()){

		int size = queue.size();
		boolean found = false;

		while(size-- > 0){
			StringBuilder peek = queue.poll();
            
            if(isValid(peek)){
                found = true;
                res.add(peek.toString());
            }
            
			for(int i = 0; i < peek.length(); i ++){

				if(peek.charAt(i) != ')' && peek.charAt(i) != '('){
                    continue;
                }
                
                StringBuilder copy = new StringBuilder(peek);
                copy.deleteCharAt(i);

                if(set.add(copy.toString())){
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
	int left = 0;
	int right = 0;
	for(int i = 0; i < sb.length(); i ++){
		if(sb.charAt(i) == '('){
			left ++;
		} else if(sb.charAt(i) ==')'){
			right ++;
			if(right > left){
				return false;
			}
		}
	}
	return left == right;
}
}