
You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount. 
You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer




/**
	Sol1: DFS

		find out distinct arrays that have same len with coins,

		each array[i] represent how many coins[i] we use

		e.g. 
		55 
		[20, 10, 5, 1]
		then [2, 1, 1, 0] is one of the array

		each node in the recursion tree is helper(coins, index, remain)

		once the index outofbound && remain == 0, then ans ++
	
		O(n^n), exponential


	Sol2: Memo DFS

		memo (remain, index) as status

		O(tar*len(coins))

	Sol3: dp

		bottom up appproch of memo dfs

		knapsack problem

		dp[i][j] means, use first i coins, # of ways add up to j

			1. init: dp[i][0] = 1
			2. f: 
			3. ans
		
		O(tar*len(coins))

*/
