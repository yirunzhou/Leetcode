public class Version1{
	public String minWindow(String s, String t){
		if(t.length() > s.length()){
			return "";
		}

		// init the result
		int resultLo = 0;
		int resultHi = 0;
		int minLen = Integer.MAX_VALUE;

		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < t.length(); i ++){
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
		}

		int counter = map.size();
		int lo = 0;
		int hi = 0;

		for(; hi < s.length();){
			char add = s.charAt(hi);
			counter = addAndUpdateMap(map, add, counter);
			hi ++;
			
			for(; lo < s.length() && counter == 0; lo ++){
				int currentLen = hi - lo;
				if(currentLen < minLen){
					resultLo = lo;
					resultHi = hi;
					minLen = currentLen;
				}
				char delete = s.charAt(lo);
				counter = deleteAndUpdateMap(map, delete, counter);
			}
		}

		return s.substring(resultLo, resultHi);
	}

	private int addAndUpdateMap(Map<Character, Integer> map, char add, int counter){
		// -1 the value of add
		if(!map.containsKey(add)){
			return counter;
		}
		map.put(add, map.get(add)-1);
		if(map.get(add) == 0){
			counter -= 1;
		}
		return counter;
	}

	private int deleteAndUpdateMap(Map<Character, Integer> map, char delete, int counter){
		// +1 the value of add, if it was updated to 1, counter +=1
		if(!map.containsKey(delete)){
			return counter;
		}
		map.put(delete, map.get(delete)+1);
		if(map.get(delete) > 0){ // CATCH, it cound be a negative number so we should not make it != 0
			counter += 1;
		}
		return counter;
	}
}