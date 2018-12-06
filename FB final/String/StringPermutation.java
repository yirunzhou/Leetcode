import java.util.*;

public class StringPermutation{

	public void permu(String input){

		char[] ch = input.toCharArray();

		Arrays.sort(ch);

		dfs(ch, 0);

	}

	// trying to determine the ch[level], and we know that [0, level-1] are unique 
	private void dfs(char[] ch, int level){

		if(level == ch.length){

			System.out.printf("Result is %s \n", String.valueOf(ch));

			return;
		}

		Set<Character> set = new HashSet<>();

		for(int i = level; i < ch.length; i ++){

			if(!set.add(ch[i])){
				continue;
			}

			swap(ch, level, i);

			dfs(ch, level + 1);

			swap(ch, level, i);
			
		}


	}

	private void swap(char[] ch, int i, int j){
		char t = ch[i];
		ch[i] = ch[j];
		ch[j] = t;
	}

	public static void main(String[] args) {
		
		StringPermutation test = new StringPermutation();

		test.permu(args[0]);

	}


}