import java.util.Random;

public class DivideInteger{


	/**
			end		sor		times
			16		3
					6
					12		4
					

			4		3		1

			1		3		base case when end < sor, return end

	*/



	public static int mod(int dividend, int divisor){

		// base case
		if(dividend < divisor){
			return dividend;
		}

		int original = divisor;

		while(dividend >= divisor + divisor){

			divisor += divisor;

		}

		return mod(dividend - divisor, original);

	}


	// input: end > sor > 0
	// BS
	// range -> [1, end]


	// mid * sor < end?
	// [0, lo) -> lo * sor <= end
	// (hi, end+1] -> hi * sor > end
	// [lo, hi] undefined
	// return lo

	// find the largest mid that sor * mid <= end

	// end = 15
	// sor = 2;

	/**
		lo	hi	mid
		0	16	8
		0	7	3	3*2 <= 15
		4	7	5	5*2 <= 15
		6	7	6	6*2 <= 15
		7	7	7	7*2 <= 15
		8	7	break return 8-1 = 7

	*/
	public static int divide(int dividend, int divisor){
		int lo = 0;
		int hi = dividend + 1;

		while(lo <= hi){

			int mid = lo + (hi - lo) / 2;

			if(mid * divisor <= dividend){

				lo = mid + 1;

			} else {

				hi = mid - 1;
			}

		}

		return lo-1;
	}



	public static void main(String[] args) {
		/*
		int end = Integer.valueOf(args[0]);
		int sor = Integer.valueOf(args[1]);
		int result =  DivideInteger.mod(end, sor);

		System.out.println(end + " % " + sor + "is " + result);

		System.out.println(result == (end % sor));

		*/

		int i = 0;
		Random rand = new Random();

		while(i < 50){

			int dividend = rand.nextInt(500) + 1;
			int divisor = rand.nextInt(dividend) + 1;

			System.out.println(DivideInteger.divide(dividend, divisor) == dividend/divisor);

			i ++;
		}
	}


}