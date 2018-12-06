







/**
	Find each one's perimeter, mark as visited

		dfs(matrix, i, j) -> return the perimeter that this grid is conneted with

			mark as visited

			calcu the edges that it is connected with island

			see its neighbors

				valid
					
					island: conncted += 1
					
						!visited: dfs it, accumulate to return result

					water: do nothing

				not valid

					nothing


			current grid edge contribute to the perimeter is 4-connected

			return 4-connected + accumulate from dfs neighbors


	return max

*/
public int islandPerimeter(int[][] matrix){

	int max = 0;

	for(int i = 0;i < matrix.length; i ++){
		for(int j = 0; j < matrix[0].length; j ++){

			if(matrix[i][j] == 1){
				max = Math.max(max, 
					dfs(matrix, i,j));
			}


		}
	}

	return max;

}



private int dfs(int[][] matrix, int i, int j){

	matrix[i][j] = -1;

	int conected = 0;

	int result = 0;

	for(int[] d : dirs){

		int x = i + d[0];
		int y = j + d[1];

		if(!isValid(matrix, x, y)){
			continue;
		}

		// island
		if(matrix[x][y] == 1 || matrix[x][y] == -1){
			connected ++;

			if(matrix[x][y] == 1){
				result += dfs(matrix, x, y);
			}
		}

	}

	return result + 4-connected;
}