


public class BigInteger{

	private String value;

	public BigInteger(String val){
		value = val;
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
		
		BigInteger bi = new BigInteger(args[1]);

		System.out.println(Long.valueOf(bi.add(args[0])) == Long.valueOf(args[1]) + Long.valueOf(args[0]));


	}


}