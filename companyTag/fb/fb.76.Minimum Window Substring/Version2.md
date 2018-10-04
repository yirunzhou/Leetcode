Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

[l, h)
             h
          l
ADOBECODEBANC

// 0. get all the occurance of T, init
// 1. advance h
// 2. check
// 3. advance l untile 2 is not valid
// repeat 1,2,3, until hi reaches the end


* hi is the char we are going to add
* lo is the char we are going to delete
* [lo, hi) means the current substring in the map

```
public int minWindow(String s, String t){

	// check corner cases
	if(s == null || t == null || s.length() < t.length()){
		return 0;
	}

	// 0.
	Map<Character, Integer> map = new HashMap<>();

	for(int i = 0 ; i < t.length(); i ++){
		map.put(t.charAt(i), map.getOrDefault(t.charAt(i))+1);
	}

	// 1.
	int lo = 0;
	int hi = 0;

	int min = Integer.MAX_VALUE;

	while(hi < s.length()){
		char add = s.charAt(hi);
		addAndUpdateMap(map, add);
		hi ++;

		while(isValid(map)){
			int curLen = hi - lo;
			min = Math.min(curLen, min);

			char delete = s.charAt(lo);
			deleteAndUpdateMap(map, delete);
			lo ++;
		}
	}

	return min;
}

private boolean isValid(Map<Character, Integer> map){
	for(int occ : map.values()){
		if(occ > 0){
			return false;
		}
	}
	return true;
}

private void addAndUpdateMap(Map<Character, Integer> map, char add){
	if(!map.containsKey(add)){
		return;
	}

	map.put(add, map.get(add)-1);
}

private void deleteAndUpdateMap(Map<Character, Integer> map, char delete){
	if(!map.containsKey(delete)){
		return;
	}

	map.put(delete, map.get(delete)+1);
}

```
