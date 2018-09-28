import java.util.Arrays;
import java.util.Random;

public class housesAndStores{

	public static int[] findClosest(int[] houses, int[] stores){
		Arrays.sort(stores);
		int[] result = new int[houses.length];

		for(int i = 0; i < houses.length; i ++){
			int pos = houses[i];
			
			// binary search
			int lo = 0;
			int hi = stores.length-1;

			while(lo + 1 < hi){
				int mid = lo + (hi - lo) /2;
				if(stores[mid] == pos){
					hi = mid;
					break;
				}
				if(stores[mid] > pos){
					hi = mid;
				} else {
					lo = mid;
				}
			}

			int distanceLo = Math.abs(stores[lo] - pos);
			int distanceHi = Math.abs(stores[hi] - pos);
			if(distanceLo <= distanceHi){
				result[i] = stores[lo];
			} else {
				result[i] = stores[hi];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] houseMatrix = new int[5][8];
		int[][] storeMatrix = new int[5][8];
		Random r = new Random();
		for(int i = 0; i < 5; i ++){
			for(int j = 0; j < 8; j ++){
				houseMatrix[i][j] = r.nextInt(6);
				storeMatrix[i][j] = r.nextInt(10);
			}
		}

		for(int i = 0; i < 5; i ++){
			int[] res = housesAndStores.findClosest(houseMatrix[i], storeMatrix[i]);

			for(int j = 0; j < res.length; j ++){
				System.out.print(storeMatrix[i][j]);
			}
				System.out.println();

			for(int j = 0; j < res.length; j ++){
				System.out.print(houseMatrix[i][j]);
			}

			System.out.println();

			for(int j = 0; j < res.length; j ++){
				System.out.print(res[j]);
			}
			System.out.println();
			System.out.println("----");
		}
	}
}