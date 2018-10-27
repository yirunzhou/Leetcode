```


class Solution{
public void nextPermutation(int[] nums) {

	if(nums == null || nums.length < 2){
		return;
	}


	/**					

		1	2	3	4	6	7	0	->	1	2	3	4	6	0	7


		other < previous premutation < cur

						i	
		1	2	4	5	3	3	9	->	

swap:

		1	2	4	3	5	3	9

		1	2	4	3	9	5	3


	


	*/


	int i = nums.length-2;

	while(i >= 0 && nums[i] <= nums[i+1]){
		i --;
	}

	// nums[i] > nums[i+1]
	// or i == -1

	if(i == -1){
		reverse(nums, 0, nums.length-1);
	}

	int j = i + 1;

	// find the first with nums[j] >= nums[i]

	while(j < nums.length && nums[j] < nums[i]){
		j ++;
	}

	j -= 1;

	swap(nums, i, j);

	reverse(nums, i+1, nums.length-1);

}




