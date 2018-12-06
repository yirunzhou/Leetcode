Smallest Range II.java

/**

Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.

*/


/**
	
	Sol1:
		
		order doesnt matter, -> sort

		Trying to let min be larger, let max be smaller,
	
		Trying to +K to A[0], -K to A[n-1], then +K to A[1], -K to A[n-2]...

		there must be a A[i], that first i choose to +K, rest choose to -K

		
		min = min(A[0] + K, A[i] - K)
		max = max(A[n-1]- K, A[i-1] + K)


		iterate i from 0 to n
		cover all the possibilities, # we choose to +K is in range of [0, n]



	Sol2:

		



*/