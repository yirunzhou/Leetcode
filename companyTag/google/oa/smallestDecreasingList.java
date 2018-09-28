import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class smallestDecreasingList{
	/**
		list is the tail elements

		iterate through nums
			iterate through list
				if we find one that is bigger than num
					replace this one to the current num

		the list is always non-decreasing

		1 2 3 7 0 5 4 3 2 0

		0 0 2 3
	*/


	public static int minDecreasingList(int[] nums){
		if(nums == null){
			return 0;
		}

		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < nums.length; i ++){
			// iterate through list of tails
			boolean found = false;
			for(int j = 0; j < list.size(); j ++){
				if(nums[i] < list.get(j)){
					list.set(j, nums[i]);
					found = true;
					break;
				}
			}
			// if we did not terminate current loop, then we need to creat a new tail
			if(!found){
				list.add(nums[i]);
			}
		}

		return list.size();
	}

	public static void main(String[] args) {
		int[] nums = {5, 5, 4, 4};
		System.out.println(smallestDecreasingList.minDecreasingList(nums) == 2);

		int[] nums2 = {};
		System.out.println(smallestDecreasingList.minDecreasingList(nums2) == 0);

		int[] nums3 = {1, 2 ,3 ,4, 5};
		System.out.println(smallestDecreasingList.minDecreasingList(nums3) == 1);

		int[][] matrix = new int[10][5];


		Random r = new Random();
		for(int i = 0; i < 10; i ++){
			for(int j = 0; j < 5; j ++){
				matrix[i][j] = r.nextInt(10);
			}
		}

		for(int i = 0; i < 10; i ++){
			for(int num : matrix[i]){
				System.out.print(num + ",");
			}
			System.out.println();
			System.out.println(smallestDecreasingList.minDecreasingList(matrix[i]));

		}


	}
}