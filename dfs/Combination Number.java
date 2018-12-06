

/**

Given an integer array A, and an integer target, 

return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.


	***VALIDATE THE INPUT FIRST***
	
		make can1 <= can2 <= can3 to dedup

		double for loop iterate can1 can2

		see can3 valid?

		if yes then get combination



	Mistakes :
	
	1. VALIDATE THE INPUT FIRST

	2. If the input's # range is limited, like a-z or 1-100, use a array to get the occ is ok

	3. check the candiate is valid in map:

		canx < canx-1 || map.get(can) == null || (canx == canx-1 && map.get(canx) == 1)

		-> continue

	4. OVERFLOW problem with % operation:

		occ.get(canx)'s max is 3000

		thus three candiiates's occ products may overflow

		***use %M afterwards is useless***

		thus we use a Map<Integer, Long> to declear occ, NEED TO PUT long type value in
			java will not autoboxing a int type to Long

	
*/