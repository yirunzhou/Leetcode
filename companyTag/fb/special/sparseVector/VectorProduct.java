/*

					i	
	  A=[[1, a1], [300, a300], [600, a600], [5000, a5000]]
		
			j														
      B=[[100, b100],[200, b200], [300, b300], [600, a600], [1000, b1000]]

*/


public class VectorProduct{

	public static int product(int[][] A, int[][] B){

		int i = 0;
		int j = 0;

		int result = 0;

		while(i < A.length && j < B.length){

			int originI = i;
			int originJ = j;

			while(i == originI || j == originJ){

				if(i >= A.length || j >= B.length){
					break;
				}

				if(A[i][0] == B[j][0]){

					result += A[i][1] * B[j][1];

					i ++;
					j ++;

				} else if(A[i][0] < B[j][0]){

					i ++;

				} else {

					j ++;
				} 

			}

		}

		return result;

		/*
			time : O(n + m)
			space : O(1)
		*/
	}


	public static int productBS(int[][] A, int[][] B){

		int result = 0;

		for(int i = 0; i < A.length; i ++){

			int targetIndex = A[i][0];
			int valA = A[i][1];

			result += binarySearch(valA, targetIndex, B);

		}

		return result;

		/*
			time O(n logm)
			space O(1)
		*/

	}


	// BS B to find B[x][0] == targetIndex, return product of valA * B[x][1], if not found return 0
	private static int binarySearch(int valA, int targetIndex, int[][] B){

		int lo = 0;
		int hi = B.length - 1;

		while(lo < hi -1){

			int mid = lo + (hi - lo) / 2;

			if(B[mid][0] == targetIndex){

				return valA * B[mid][1];

			} else if(B[mid][0] > targetIndex){

				hi = mid;

			} else {

				lo = mid;
			}

		}

		// post process when lo hi is adjacent

		if(B[hi][0] == targetIndex){
			return valA * B[hi][1];
		}

		if(B[lo][0] == targetIndex){
			return valA * B[lo][1];
		}

		return 0;
	}


	public static void main(String[] args) {
		int[][] A = new int[][]{{0, 0}, {2, 220}, {500, 5}, {6000,1}, {10000, 9}};
		int[][] B = new int[][]{{1, 1}, {30, 220}, {500, 5}, {6000, 3}};

		System.out.println(VectorProduct.productBS(A,B));
	}
}