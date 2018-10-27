


```



/**
	
	3	8	9	4	2	7	6	5	0

->	3	8	9	4	5	7	6	2	0

					lo			hi



	3	8	9	4	5	0	2	6	7


	1. get the two number to be swap

		mark there index as lo, hi

		num[lo] < num[lo+1] -> lo stop

		num[hi] >= nums[lo] -> hi ++;


	2. rearrange the number (lo, len-1]

		to get a smallest bigger number


	corner cases:

		empty

		len = 1

		654321

*/

class Solution {
    public void nextPermutation(int[] nums) {

    	if(nums == null || nums.length < 2){
    		return;
    	}

        int lo = nums.length - 2;

        while(lo >= 0 && nums[lo] >= nums[lo+1]){
        	lo --;
        }

        if(lo == -1){
        	reverse(nums, 0, nums.length-1);
        	return;
        }

        int hi = lo + 1;

        while(hi < nums.length && nums[lo] < nums[hi]){
        	hi ++;
        }

        swap(nums, lo, hi-1);

        reverse(nums, lo + 1, nums.length-1);
    }


    private void swap(int[] nums, int i, int j){

    	int t = nums[i];

    	nums[i] = nums[j];

    	nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j){

    	while(i < j){
    		swap(nums, i, j);
    		i ++;
    		j --;
    	}
    }


}