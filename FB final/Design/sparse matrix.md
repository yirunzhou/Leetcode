sparse matrix.md

public class Matrix{

	public class Vector{

		List<int[]> list = new ArrayList<>();

		public Vector(int[] v){

			for(int i = 0; i < v.length; i ++){
				if(v[i] != 0){
					list.add(i, v[i]);
				}
			}
		}
	}

	Vector[] vectors;

	public Matrix(int[][] matrix){

		vectors = new int[matrix.length];

		for(int i = 0 ; i < matrix.length; i ++){

			vectors[i] = new Vector(matrix[i]);

		}

	}


	


}