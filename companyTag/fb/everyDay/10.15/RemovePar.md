Title	Acceptance	Difficulty	Frequency
301	
Remove Invalid Parentheses	36.8%	Hard	
273	
Integer to English Words	23.1%	Hard	
15	
3Sum	22.2%	Medium	
253	
Meeting Rooms II
40.3%	Medium	
31	
Next Permutation	29.3%	Medium	
621	
Task Scheduler	42.6%	Medium	
121	
Best Time to Buy and Sell Stock	44.6%	Easy	
67	
Add Binary	36.0%	Easy	
10	
Regular Expression Matching	24.4%	Hard	
297	
Serialize and Deserialize Binary Tree	37.0%	Hard	
426	
Convert Binary Search Tree to Sorted Doubly Linked List


```


	public List<String> removeInvalidParentheses(String s) {

		List<String> result = new ArrayList<>();

		bfs(result, new StringBuilder(s));

		return result;
	}


	private void bfs(List<String> result, StringBuilder origin){

		Queue<StringBuilder> queue = new LinkedList<>();

		Set<String> set = new HashSet<>();

		queue.offer(origin);

		set.add(origin.toString());



		while(!queue.isEmpty()){

			int size = queue.size();

			for(int i = 0; i < size; i ++){

				StringBuilder cur = queue.poll();

				if(isValid(cur)){
					result.add(cur);
				}

				for(int delete = 0; delete < cur.length(); delete ++){

					StringBuilder copy = new StringBuilder(cur);

					copy.deleteCharAt(delete);

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
			} else if(sb.charAt(i) == ')'){
				if(counter == 0){
					return false;
				}
				counter --;
			}
		}

		return counter == 0;
	}