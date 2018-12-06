import java.util.*;

public class Vector{

	List<int[]> list = new ArrayList<>();

	public Vector(int[] v){

		for(int i = 0; i < v.length; i ++){
			if(v[i] != 0){
				list.add(new int[]{i, v[i]});
			}
		}
	}


	public int productTP(Vector v2){
		Vector v1 = this;

		int result = 0;

		int i = 0;
		int j = 0;

		while(i < v1.list.size() && j < v2.list.size()){

			int[] pair1 = v1.list.get(i);
			int[] pair2 = v2.list.get(j);

			if(pair1[0] == pair2[0]){
				result += pair1[1] * pair2[1];
				i ++;
				j ++;
			} else if (pair1[0] > pair2[0]) {
				j ++;
			} else{
				i ++;
			}
		}

		return result;

	}


	public int productBS(Vector v2){

		Vector v1 = this;

		int result = 0;

		for(int[] pair : v1.list){

			int targetIndex = pair[0];

			// return the value of corisponding index in v2, not exsits return 0;
			int valueInV2 = binarySearch(v2, targetIndex);

			result += pair[1] * valueInV2;

		}

		return result;
	}

	private int binarySearch(Vector v, int target){
		List<int[]> list = v.list;

		int lo = 0;
		int hi = list.size()-1;

		/**
			[0, lo) is pair that pair[0] < target
			(hi, len-1] is pair that pair[0] > target
		*/

		while(lo <= hi){

			int mid = lo + (hi-lo) / 2;

			if(list.get(mid)[0] == target){
				return list.get(mid)[1];
			} else if(list.get(mid)[0] > target){
				hi = mid-1;
			} else {
				lo = mid+1;
			}

		}
		return 0;
	}

	public static void main(String[] args) {

		int[] test1 = new int[1000];

		test1[100] = 200;
		test1[200] = 10;
		test1[500] = 300;


		int[] test2 = new int[1000];

		test2[101] = 200;
		test2[200] = 10;
		test2[400] = 300;
		test2[500] = 10;
		

		Vector v1 = new Vector(test1);
		Vector v2 = new Vector(test2);

		System.out.println(v1.productBS(v2));
	}

}



