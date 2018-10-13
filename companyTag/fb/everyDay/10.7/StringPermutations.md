```
public class StringPermutations{
	
	public List<String> stringPermu(String input){
		
		char[] inputArray = input.toCharArray();
		
		Arrays.sort(inputArray);

		List<String> result = new ArrayList<>();

		boolean[] visited = new boolean[inputArray.length];

		dfs(result, inputArray, new char[inputArray.length], 0, visited);

		return result;

	}


	private void dfs(
		List<String> result, 
		char[] input, 
		char[] temp, 
		int level, 
		boolean[] visited){

			// exit
			if(level == input.length){
				result.add(new String(temp));
				return;
			}


			// decide which character will be put in temp[level]

			for(int i = 0; i < input.length; i ++){
				if(visited[i]){
					continue;
				}

				if(i != 0 && input[i] == input[i-1] && !visited[i-1]){
					continue;
				}

				temp[level] = input[i];
				visited[i] = true;

				dfs(result, input, temp, level + 1, visited);

				visited[i] = false;
			}

	}

}
