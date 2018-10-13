
import java.util.List;


public class FindAllAnagramInAString{
	public List<Integer> FindAllAnagramInAString(String s, String p){
		List<String> res = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < p.length(); i ++){
			map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
		}

		int count = 0;
		int lo = 0, hi = 0;


		while(hi < p.length() - 1){

		}

	}

	private int update(Map<Character, Integer> map, char c, int counter, boolean isHi){
		if(!map.containsKey(c)){
			return counter;
		}

		int toMatch = map.get(c);
		if(isHi){
			if(toMatch == 0){
				counter --;
			} else if(toMatch == 1){
				counter ++;
			}
			map.put(c, toMatch -1);
		} else {
			if(toMatch == 0){
				counter --;
			} else if(toMatch == -1){
				counter ++;
			}
			map.put(c, toMatch +1);
		}
		return counter;
	}

	/*

		When only hi is expanding until hi - lo + 1 == p's length
			
			hi ++

			Case1:
				not in the map
				do nothing

			Case2:
				in the map
				get the toMatch value of current char from map
				if toMatch is 0
					counter --;
				else if toMatch is 1
					counter ++;
				update current char's value to toMatch -1;

		
		Sliding

			evaluate current [lo, hi] is anagram or not

			hi:
				Same above


			lo :
				Case 1: 
					not int the map
				Case 2:
					in the map
					get toMatch value of current char from map
					if toMatch is 0
						counter --
					else if toMatch is -1
						counter ++
					update with toMatch + 1

				lo++ CATCH : lo ++ after update map



	*/

}