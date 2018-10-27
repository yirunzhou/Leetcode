```


class Solution {
    public List<String> removeInvalidParentheses(String s) {

    	List<String> result = new ArrayList<>();

    	bfs(result, s);

    	return result;
    }


    private void bfs(List<String> result, String s){

    	StringBuilder origin = new StringBuilder(s);

    	Queue<StringBuilder> queue = new LinkedList<>();

    	Set<String> visited = new HashSet<>();

    	queue.offer(origin);

    	visited.add(origin.toString());


    	while(!queue.isEmpty()){

    		int size = queue.size();

    		for(int i = 0; i < size; i ++){

    			StringBuilder cur = queue.poll();

    			if(isValid(cur)){
    				result.add(cur.toString());
    			}

    			for(int j = 0; j < cur.length(); j ++){

    				StringBuilder copy = new StringBuilder(cur);

    				copy.deleteCharAt(j);

    				if(visited.add(copy.toString())){
    					queue.offer(copy);
    				}

    			}

    		}

    		if(result.size() != 0){
    			break;
    		}

    	}

    }

    private boolean isValid(StringBuilder sb){

    	int counter = 0;

    	for(int i  = 0; i < sb.length(); i ++){

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
}