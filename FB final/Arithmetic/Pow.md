```


	
	Iterative:

		State machine,

			Init A, N, X with 1, n, x

			Invariant is A * X^N === x^n

			CASE1 (N & 1) == 1:		N-= 1, A *= X

			CASE 2 ... :			N/=2, X*=X



		Time: logn
		Space: 1


	Recursive:

		Helper function return the value of x^n

		helper(double x, int n)

			CASE 1:

				n is odd, return helper(x, n/2) * helper(x, n/2) * x

			CASE 2:

				n is even, return helper(x, n/2) * helper(x, n/2)


		Time: logn
		Space: logn


	Mistakes:

		Variable scope

		Bit operation priority is lower than == -> (N&1) == 1



public double pow(double x, int n){

	if(x == 0){
		return 0;
	}

	long nl = Math.abs((long)n);


	double A = 1;

	double X = n < 0 ? 1/x : x;

	long N = nl;


	// A * X^N = x^n

	while(N != 0){

		if((N & 1) == 1){

			N -= 1;
			A *= X;

		} else{

			N >>= 1;
			X *= X;
		}

	}

	return A;
}



