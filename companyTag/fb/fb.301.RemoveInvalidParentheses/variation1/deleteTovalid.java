import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


	

public class DeleteTovalid{

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

	public static String deleteInPlace(String input){

		char[] c = input.toCharArray();

		int lo = 0;
		int hi = 0;
		int counter = 0;

		while(hi < c.length){

			if(c[hi] == '('){
				counter ++;

				c[lo] = c[hi];

				lo ++;
				hi ++;
			} else {

				if(counter == 0){

					hi ++;
				} else {

					counter --;
					c[lo] = c[hi];
					lo ++;
					hi ++;
				}
			}
		}

		int end = lo;

		lo = end-1;
		hi = end-1;
		counter = 0;

		while(hi >= 0){

			if(c[hi] == ')'){

				counter ++;

				c[lo] = c[hi];
				lo --;
				hi --;

			} else {

				if(counter == 0){
					hi --;
				} else {

					counter --;
					c[lo] = c[hi];
					lo --;
					hi --;
				}
			}
		}

		StringBuilder result = new StringBuilder();

		for(int i = lo+1; i < end; i ++){
			result.append(c[i]);
		}

		return result.toString();
	}



public static String removeParenth(String input){

	char[] ch = input.toCharArray();

	int lo = 0;
	int hi = 0;

	int counter = 0;

	while(hi < ch.length){

		if(ch[hi] == '('){
			counter ++;

			ch[lo++] = ch[hi++];

		} else if(ch[hi] == ')'){

			if(counter == 0){

				hi ++;

			} else {
				counter --;

				ch[lo++] = ch[hi++];

			}

		}
	}


	int end = lo;

	/**
		// [0, lo) is valid for ')'

		(	(	)	(	)	) 	(
	
		// record the end point
	*/

	lo = end -1;
	hi = end -1;

	counter = 0;

	while(hi >= 0){

		if(ch[hi] == ')'){
			counter ++;

			ch[lo --] = ch[hi --];

		} else {
			if(counter == 0){

				hi--;

			} else {

				counter --;

				ch[lo --] = ch[hi --];
			}

		}

	}

	// (lo, end) is the valid parenth

	StringBuilder result = new StringBuilder();

	for(int i = lo+1; i < end; i ++){
		result.append(ch[i]);
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

		DeleteTovalid test = new DeleteTovalid();

		List<String> resultList = test.removeInvalidParentheses(input.toString());

		String result = DeleteTovalid.removeParenth(input.toString());

		System.out.println(result);

		System.out.println(resultList);
		System.out.println(resultList.contains(result));

	}


	public List<String> removeInvalidParentheses(String s) {

		List<String> result = new ArrayList<>();

		bfs(result, s);

		return result;
	}


	private void bfs(List<String> result, String s){

		Set<String> visited = new HashSet<>();
		Queue<StringBuilder> queue = new LinkedList<>();

		queue.offer(new StringBuilder(s));
		visited.add(s);

		while(!queue.isEmpty()){

			int size = queue.size();
			boolean found = false;

			while(size-- > 0){
				StringBuilder cur = queue.poll();

				if(isValid(cur)){
					found = true;
					result.add(cur.toString());
				}

				for(int i = 0; i < cur.length(); i ++){

					StringBuilder copy = new StringBuilder(cur);

					copy.deleteCharAt(i);

					if(visited.add(copy.toString())){
						queue.offer(copy);
					}
				}
			}

			if(found){
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
				counter --;
				if(counter < 0){
					return false;
				}
			}
		}

		return counter == 0;
	}
}