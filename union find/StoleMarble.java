
private int stole(int[][] matrix){

	int counter = 0;

	for(int i = 0; i < matrix.length; i ++){
		for(int j = 0; j < matrix[0].length; j ++){
			if(matrix[i][j] == 1){
				counter ++;
			}
		}
	}

	int island = 0;
	boolean[][] used = new boolean[matrix.length][matrix[0].length];

	for(int i = 0; i < matrix.length; i ++){
		for(int j = 0; j < matrix[0].length; j ++){

			if(matrix[i][j] == 1 && !used[i][j]){
				island ++;
				// mark the same col or row to be used
				dfs(matrix, i, j, used);
			}

		}
	}

	return counter - island; 
}

private void dfs(int[][] matrix, int row, int col, boolean[][] used){

	used[row][col] = true;

	for(int i = 0; i < matrix.length; i ++){
		if(matrix[i][col] == 1 && !used[i][col]){
			dfs(matrix, i, col, used);
		}
	}


	for(int j = 0; j < matrix[0].length; j ++){
		if(matrix[row][j] == 1 && !used[row][j]){
			dfs(matrix, row, j, used);
		}
	}

}





