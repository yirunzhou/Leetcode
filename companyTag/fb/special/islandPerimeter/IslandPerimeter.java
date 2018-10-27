
```
public class IslandPerimeter{
	

	public int maxPerimeter(int[][] matrix){

		if(matrix == null || matrix.length == 0){
			return 0;
		}

		int max = 0;

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		for(int i = 0; i < matrix.length; i ++){

			for(int j = 0; j < matrix[0].length; j ++){

				if(matrix[i][j] == 0 || visited[i][j]){
					continue;
				}

				int curPer = bfs(matrix, i, j, visited);

				max = Math.max(max, curPer);
			}
		}

		return max;
	}

	private static final int[][] dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};

	private int bfs(int[][] matrix, int i, int j, boolean[][] visited){

		int result = 0;

		Queue<Cor> queue = new LinkedList<>();

		queue.offer(new Cor(i, j));

		visited[i][j] = true;


		while(!queue.isEmpty()){

			Cor cur = queue.poll();

			visited[cur.x][cur.y] = true;
			
			int curP = 4;

			for(int[] d : dirs){

				// neigh's cor
				int x = cur.x + d[0];
				int y = cur.y + d[1];

				if(isValid(x, y, matrix) && matrix[x][y] == 1){
					curP -= 1;
				}

				if(!visited[x][y]){
					queue.offer(new Cor(x, y));
				}
			}

			result += curP;

		}

		return result;

	}

	private int dfs(int[][] matrix, int i, int j, boolean[][] visited){

		visited[i][j] = true;

		int result = 0;

		int curGrid = 4;

		for(int[] d : dirs){

			int x = i + d[0];
			int y = j + d[1];

			if(isValid(x, y, matrix) && matrix[x][y] == 1){
				curGrid -= 1;

				if(!visited[x][y]){
					result += dfs(matrix, x, y, visited);
				}
			}
		}

		result += curGrid;

		return result;
	}


 	private boolean isValid(int x, int y, int[][] grid){
        
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            return false;
        }
        
        return true;
    }

	private class Cor{
		int x;
		int y;

		public Cor(int i, int j){
			x = i;
			y = j;
		}

	}

	public static void main(String[] args) {

		IslandPerimeter ip = new IslandPerimeter();

		int n = Integer.valueOf(args[0]);

		int[][] matrix = new int[n][n]

		for(int i = 0; i < n; i ++){

			for(int j = 0; j < n; j ++){

			}
		}
	}

}