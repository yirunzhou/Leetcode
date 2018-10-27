
import java.util.Comparator;


public class StringComparator implements Comparator<String>{


	/*

			1. both are char

				if same then continue

				else return compare

			2. both are numbers

				from current pointer, get the number

				compare two numbers

				if same continue

				else return compare

			3. one is char one is number

				then number is bigger

	*/


	@Override
	public int compare(String s1, String s2){

		if(s1 == null && s2 == null){
			return 0;
		}

		if(s1 == null){
			return -1;
		}

		if(s2 == null){
			return 1;
		}

		int p1 = 0;
		int p2 = 0;

		while(p1 < s1.length() && p2 < s2.length()){

			char c1 = s1.charAt(p1);
			char c2 = s2.charAt(p2);

			// both are letter

			if(Character.isLetter(c1) && Character.isLetter(c2)){

				if(c1 == c2){
					p1 ++;
					p2 ++;
					continue;	
				} else {
					return c1 - c2;
				}
				
			}


			// only one of them is number

			if(!(Character.isDigit(c1) && Character.isDigit(c2))){

				if(Character.isDigit(c1)){
					return 1;
				} else {
					return -1;
				}

			}


			// both are numbers

			int start1 = p1;

			while(p1 < s1.length() && Character.isDigit(s1.charAt(p1))){
				p1 ++;
			}

			int start2 = p2;

			while(p2 < s2.length() && Character.isDigit(s2.charAt(p2))){
				p2 ++;
			}

			Long num1 = Long.valueOf(s1.substring(start1, p1));
			Long num2 = Long.valueOf(s2.substring(start2, p2));

			int numCompare = num1.compareTo(num2);

			if(numCompare != 0){
				return numCompare;
			}

		}

		if(p1 < s1.length()){

			return 1;

		} else if(p2 < s2.length()){

			return -1;
		}

		return 0;

	}
}