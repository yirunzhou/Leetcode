Maximum Sum Circular Subarray.java



/**

	Cricular -> 1. split 2. dup 3. inverse

	1. itereate over the split point, reconstruct the array, get max

	2. dup the array ...?

			[     ]
		FFFFFFFFFSSSSSSSSSS

	3. get the maxSub and minSub, circularMax = total - minSub

		 	[	]
		FFFFFFFFFFFFFFF
		

	Solution for 3.


		trying to get:

			maxSub
			minSub


		running sum [0, i]:

			running

		previous minmax of running, [0, i-1]:(thus we will not get empty subarray as candidate)

			prevMin
			prevMax
		

		Init:
			
			maxSub, minSub -> A[0] , as we need non-empty array
			running -> 0
			prevMin, prevMax -> 0, means the prev is empty array, which is allowed as we can get subarray from start


		loop through the i

			running += A[i]

			update maxSub, minSub

			update minPrev, maxPrev


		post process:

			! We may get minSub to be the whole array, so maybe will result in empty candidate
			! thus need to rule out the possibility

			if(minSub == total) return maxSub

			return max(maxSub, total - minSub)
	
*/