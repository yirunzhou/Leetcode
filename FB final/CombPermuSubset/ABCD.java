

public class ABCD{


	public void pairs(int[] nums){

		for(int a = 0; a < nums.length; a ++){

			for(int b = a + 1; b < nums.length; b ++){

				int sum1 = nums[a] + nums[b];

				for(int c = a+1; c < nums.length; c ++){

					for(int d = c+1; d < nums.length; d++){

						int sum2 = nums[c] + nums[d];

						if(sum1 == sum2){

							//if((c == a && d > b) || c > a){
							if(b != d){
								System.out.printf("nums[%d] + nums[%d] = nums[%d] + nums[%d] ", 
									a, b, c, d);
								System.out.printf("Value is %d, %d, %d, %d\n",
									nums[a], nums[b], nums[c], nums[d]);

							}

						}

					}

				}

			}

		}

	}


	public static void main(String[] args) {
		

		ABCD test = new ABCD();

		test.pairs(new int[]{0, 1, 2, 4, 3, 5});

		


	}


}