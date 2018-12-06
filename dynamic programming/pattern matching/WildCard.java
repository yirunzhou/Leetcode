

/**
	
	memo search can help to reduce redun searching, from 2^n -> mn

	memo search use a visited flag to if we have the result or not, 
		no enough info when just have boolean[][] match
	

	So in this question:(When memo search, we need to get smaller subquestions result)
		
		we look at i, j
		
		CASE 1: 
			j -> ? or char
			dp[i][j] = dp[i+1][j+1]

		
		CASE 2:
			j -> *

			2.1 match nothing -> helper(i, j+1)
			2.2 match current and maybe further sequence -> helper(i+1, j) 
				thus i+1 may still use current j as match or not, so does i+2, i+3 ....
				thus it can match sequence

		Init:
			i+1 == len
			j+1 == len
			
			thus we call j+1 with helper function helper(i, j+1) ->

				in this functioon we have j == len
				thus j == len and i == len is the base case
		
			1. i == len -> no s left, thus in p there should be all * from [j, len-1]
			2. j == len -> no p left, thus in s it should be empty -> i == len

*/

