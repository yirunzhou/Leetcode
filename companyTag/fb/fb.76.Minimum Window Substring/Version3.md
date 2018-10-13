

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


```

class Solution {
    public String minWindow(String s, String t) {
        
    	if(t.length() > s.length()){
    		return "";
    	}

    	Map<Character, Integer> map = new HashMap<>();

    	for(int i = 0; i < t.length(); i ++){
    		map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    	}

    	int counter = map.size();

    	int lo = 0;
    	int hi = 0;

    	int resultLo = 0;
    	int resultHi = 0;
    	int minLen = Integer.MAX_VALUE;


    	for(lo < s.length()){

    		while(hi < s.length() && counter != 0){

    			counter = addToSubstring(map, s.charAt(hi), counter);
    			hi ++;

    		}

    		if(counter == 0){

    			int curLen = hi - lo;

    			if(curLen <= minLen){

    				minLen = curLen;
    				resultLo = lo;
    				resultHi = hi;
    			}

    		}

    		counter = deleteToSubstring(map, s.charAt(lo), counter);
    		lo ++;
    	}

    	return s.substring(resultLo, resultHi);
    }
}

private void isValid(Map<Character, Integer> map){

	for(int toMatch : map.values()){
		if(toMatch > 0){
			return fasle;
		}
	}

	return true;
}

private void addToSubstring(Map<Character, Integer> map, char add, int counter){
	if(map.containsKey(add)){
		map.put(add, map.get(add) - 1);
		if(map.get(add) == 0){
			counter --;
		}
	}
	return counter;
}

private void deleteToSubstring(Map<Character, Integer> map, char delete, int counter){
	
	if(map.containsKey(delete)){
		map.put(delete, map.get(delete) + 1);

		if(map.get(delete) == 1){
			counter ++;
		}
	}

	return counter;
}