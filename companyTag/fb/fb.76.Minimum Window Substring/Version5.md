```




public String minWindow(String s, String t){

	Map<Character, Integer> map = new HashMap<>();

	for(char c : t.toCharArray()){
		map.put(c, map.getOrDefault(c, 0) + 1);
	}

	int counter = t.length();

	int lo = 0;
	int hi = 0;

	int resultLo = 0;
	int resultHi = 0;

	int minLen = s.length();

	for(; lo < s.length() && lo <= hi; lo ++){

		while(hi < s.length() && counter > 1){
			counter = add(map, s.charAt(hi), counter);
			hi ++;
		}

		if(counter <= 1){
			int curLen = hi - lo;
			if(curLen <= minLen){
				minLen = curLen;
				resultLo = lo;
				resultHi = hi;
			}
		}

		counter = delete(map, s.charAt(lo), counter);
	}

	return s.substring(resultLo, resultHi);
}


private void add(Map<Character, Integer> map, char add, int counter){

	if(!map.containsKey(add)){
		return counter;
	}

	int prev = map.get(add);

	if(prev > 0){
		counter --;
	}

	map.put(add, prev-1);

	return counter;
}


private void delete(Map<Character, Integer> map, char delete, int counter){

	if(!map.containsKey(delete)){
		return counter;
	}

	int prev = map.get(delete);

	if(prev == 0){
		counter ++;
	}

	map.put(delete, prev + 1);

	return counter;
}