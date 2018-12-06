


public class BigInteger{

	private String value;

	public BigInteger(String val){
		value = val;
	}
	/**

	Case 1:
	i
		1	2	3	4

	-		1	9	7
					
		1	0	3	7
		


		0

		-> reverse -> 0	 3	3	7 -> 3	3 7	 -> negtive or positive? insert "-"

		return
		

					
	diff = carry + n1 - n2

	if diff < 0
		carry = -1

		diff += 10

	move to next position

	Case 2:

			8	9	7

	-	1	2	3	4

	-> compare which has larger abs using some other helper function



	*/
	/**
		1. both negative -> add positive -> add "-"

		2. one of them is negative -> compare to determin the sign (other function)

		-> substract larger one with smaller one

	*/

	// num2 is negative and it has smaller absolute value

		/**
			

		*/
	public String addWithNeg(String num2){

		String num1 = this.value;

		int i = num1.length()-1;

		int j = num2.length()-1;

		int carry = 0;

		StringBuilder result = new StringBuilder();

		// j == 0 is the negative sign
		while(i >= 0 || j >= 1){

			int n1 = i >= 0? (num1.charAt(i) - '0') : 0;

			int n2 = j >= 1? (num2.charAt(j) - '0') : 0;

			int sum = carry + n1 - n2;

			if(sum < 0){

				carry = -1;
				sum += 10;

			} else{

				carry = 0;

			}


			result.append(sum);

			i --;
			j --;

		}

		// trailing 0
		while(result.length() > 0 && result.charAt(result.length()-1) == '0'){
			result.deleteCharAt(result.length()-1);
		}

		result.reverse();

		if(result.length() == 0){
			return "0";
		}

		return result.toString();

	}


	public String addWithFraction(String frac1){

		

	}









	public String multiply(String num2){

		if(num2.length() == 0){
			return "0";
		}

		String num1 = value;

		int[] result = new int[num1.length() + num2.length()];

		// i -> num1
		// j -> num2

		for(int i = num1.length()-1; i >= 0; i --){

			for(int j = num2.length()-1; j >= 0; j --){

				int prod = (num1.charAt(i) - '0') 
						 * (num2.charAt(j) - '0');

				result[i+j+1] += prod;

			}
		}

		// handle carry

		for(int i = result.length-1; i > 0; i --){

			if(result[i] >= 10){

				result[i-1] += result[i]/10;
				result[i] %= 10;

			}

		}

		StringBuilder resultStr = new StringBuilder();

		for(int i = 0; i < result.length; i ++){
			// handle leading 0

			if(resultStr.length() == 0 && result[i] == 0){
				continue;
			}

			resultStr.append(result[i]);

		}

		return resultStr.length() == 0 ? "0" : resultStr.toString();

	}

	public String add(String num2){

		String num1 = value;

		StringBuilder resultStr = new StringBuilder();

		int carry = 0;

		int i = num1.length()-1;

		int j = num2.length()-1;

		while( i>=0 || j >=0 ){

			int n1 = i >= 0 ? (num1.charAt(i) - '0') : 0;

			int n2 = j >= 0 ? (num2.charAt(j) - '0') : 0;

			int sum = n1 + n2 + carry;

			carry = sum / 10;

			resultStr.append(sum % 10);

			i --;
			j --;

		}

		if(carry != 0){
			resultStr.append(1);
		}

		resultStr.reverse();

		return resultStr.toString();

	}


	public static void main(String[] args) {
		
		BigInteger bi = new BigInteger(args[0]);

		System.out.println(Long.parseLong(bi.addWithNeg(args[1])));

		System.out.println(Long.parseLong(args[0]) + Long.parseLong(args[1]));


	}


}