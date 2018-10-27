```


first, get two adjacent words

	find the first different character pair

	add to graph, before -> after


then, get indegree of all the chars in the word list


start topological sort from indegree == 0's char




public String alienOrder(String[] words) {
	

	Map<Character, Set<Character>> graph = new HashMap<>();

	Map<Character, Integer> indegree = new HashMap<>();


	for(int i = 0; i < word.length -1; i ++){

		String cur = words[i];
		String next = words[i+1];

		int len = Math.min(cur.length(), next.length());

		for(int j = 0; j < len; j ++){

			if(cur.charAt(j) == next.charAt(j)){
				continue;
			}

			// got the different char pair

			char before = cur.charAt(j);
			char after  = next.charAt(j);



			// add after to the before's child

			Set<Character> childSet = graph.get(before);

			if(childSet == null){
				graph.put(before, new HashSet<Character>());

				childSet = graph.get(before);
			}

			childSet.add(after);


			// after the first different pair, the rest of chars are meanningless

			break;

		}
	}


	for(String word : words){

		for(char c : word.toCharArray()){
			indegree.put(c, 0);
		}

	}

	for(Set<Character> childSet : graph.values()){

		for(char child : childSet){

			indegree.put(child, indegree.get(child) + 1);

		}
	}



	Queue<Character> queue = new LinkedList<>();

	for(Map.Entry<Character, Integer> e : indegree.entrySet()){

		if(e.getValue() == 0){
			queue.offer(e.getKey());
		}

	}

	StringBuilder result = new StringBuilder();

	while(!queue.isEmpty()){

		char cur = queue.poll();

		result.append(cur);

		for(char child : graph.get(cur)){

			int prevIndegree = indegree.get(child);

			indegree.put(child,  prevIndegree -1);

			if(prevIndegree == 1){

				queue.offer(child);

			}

		}

	}

	return result.length() == indegree.size() ? result.toString : "";

}