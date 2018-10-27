
1. will the loop TERMINATE ? everytime you write WHILE, be sure it will QUIT



```
class Solution {
    public void moveZeroes(int[] nums) {

    	/**
			0	1	2	0	3	4	0	0	

											j
											i
			1	2	3	4	0	0	0	0	

    	*/


		int lo = 0;
		int hi = 0;

		while(hi < nums.length){

			if(nums[hi] == 0){

				hi ++;

			} else {

				nums[lo] = nums[hi];
				lo ++;
				hi ++;

			}
		}

		while(lo < nums.length){

			if(nums[lo] != 0){
				nums[lo] = 0;
			}

			lo ++;
		}

    }
}


```