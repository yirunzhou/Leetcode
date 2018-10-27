
public class UniquePath{

	public void printUniquePath(char[][] grid){

		helper(grid, new StringBuilder(), 0, 0);

	}

	// choose down or right dirction, valid?
	// append path into prefix
	// a->b->c
	private static final int[][] dirs = {{1, 0}, {0, 1}};


	// path - path before reach current point, with "->" or without when i, j is start
	private void helper(char[][] grid, StringBuilder path, int i, int j){

		// reached the end point
		if(i == grid.length -1 && j == grid[0].length-1){
			path.append(grid[i][j]);

			System.out.println(path);

			path.deleteCharAt(path.length()-1);

			return;
		}

		// not the end, so append path

		path.append(grid[i][j]);

		path.append("->");

		for(int[] d : dirs){

			int x = i + d[0];
			int y = j + d[1];

			if(isValid(x, y, grid)){
				helper(grid, path, x, y);
			}

		}

		for(int k = 0; k < 3; k ++){
			path.deleteCharAt(path.length()-1);
		}

	}

	private boolean isValid(int x, int y, char[][] grid){
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
			return false;
		}
		return true;
	}


	public static void main(String[] args) {


		char[][] test = {{'a','b', 'c'},{'d', 'e', 'f'}, {'g', 'e', 'h'}};

		UniquePath up = new UniquePath();

		up.printUniquePath(test);


	}


}