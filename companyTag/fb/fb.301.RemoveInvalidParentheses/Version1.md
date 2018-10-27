```


	0	1	2	3	4	5	6
	(	(	(	)	)	(	(	

	queue: 

	(	(	)	)	(	(
	(	(	(	)	(	(
	(	(	(	)	)	(

	// should not choose the adjacent same bracket
	// 

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        bfs(result, s);

        return result;
    }

    private void bfs(List<String> result, String s){


    	StringBuilder origin = new StringBuilder(s);

    	Set<String> set = new HashSet<>();

    	Queue<StringBuilder> queue = new LinkedList<>();

    	queue.offer(origin);
    	set.add(origin.toString());


    	while(!queue.isEmpty()){

    		int size = queue.size();


    		for(int i = 0; i < size; i ++){

    			StringBuilder cur = queue.poll();

    			if(isValid(cur)){
    				result.add(cur.toString());
    			}

    			for(int j = 0; j < cur.length(); j ++){

    				if(cur.charAt(j) != ')' && cur.charAt(j) != '('){
    					continue;
    				}

    				StringBuilder copy = new StringBuilder(cur);

    				copy.deleteCharAt(j);

    				if(set.add(copy.toString())){

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

    	for(int i = 0; i < sb.length(); i ++){

    		if(sb.charAt(i) == '('){
    			counter ++;
    		} else if (sb.charAt(i) == ')'){
    			if(counter == 0){
    				return false;
    			}
    			counter --;
    		}

    	}

    	return counter == 0;
    }

}