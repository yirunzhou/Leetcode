import java.util.HashSet;
import java.util.Set;
import java.util.Random;


public class deleteTovalid{

	public static String delete(String input){

		int counter = 0;

		Set<Integer> deleteIndex = new HashSet<>();

		for(int i = 0; i < input.length(); i ++){

			char cur = input.charAt(i);

			if(counter == 0 && cur == ')'){
				deleteIndex.add(i);
				continue;
			}

			if(cur == '('){
				counter ++;
			} else if(cur == ')'){
				counter --;
			}
		}

		counter = 0;

		for(int i = input.length()-1; i >= 0; i --){

			char cur = input.charAt(i);

			if(counter == 0 && cur == '('){
				deleteIndex.add(i);
				continue;
			}

			if(cur == ')'){
				counter ++;
			} else if(cur == '('){
				counter --;
			}
		}

		StringBuilder result = new StringBuilder();

		for(int i = 0; i < input.length(); i ++){
			
			if(deleteIndex.contains(i)){
				continue;
			}

			result.append(input.charAt(i));
		}

		return result.toString();
	}

	public static void main(String[] args) {
		
		StringBuilder input = new StringBuilder();

		Random r = new Random();

		for(int i = 0; i <= r.nextInt(50); i ++){
			if(r.nextBoolean()){
				input.append('(');
			} else {
				input.append(')');
			}
		}

		System.out.println(input);

		String result = deleteTovalid.delete(input.toString());

		System.out.println(result);

	}
}