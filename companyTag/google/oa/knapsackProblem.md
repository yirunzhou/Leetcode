


// k is capacity
public int knapsack(int[] val, int[] weight, int k){
	
	/*
		i - if we just have [0, i] items
		j - if we just have j capacity

		dp[i][j] - max val we can get from [0, i] items, with j capacity

		dp[i][0] = 0

		dp[i][j]

			if j >= weight[i], we have CASE1 CASE2
			else we just have CASE2

			CASE1 : get the item i
				remain capacity we have is j - weight[i]
				max val we can get is dp[i-1][remain] + val[i]

			CASE2 : no
				dp[i-1][j]

			dp[i][j] = max(case1 , case2)
	*/


	/*
		val weight is null || len = 0
		return 0
	*/

	if(val == null || val.length == 0){
		return 0;
	}

	int[][] dp = new int[val.length+1][k+1];

	for(int i = 1; i < dp.length; i ++){
		for(int j = 0; j < dp[0].length; j ++){
			int itemIndex = i - 1;

			// CASE 1
			if(j >= weight[itemIndex]){
				dp[i][j] = dp[i-1][j-weight[itemIndex]] + val[itemIndex];

				// int remain = j - weight[itemIndex];
				// int maxRemain = dp[i-1][remain];
				// dp[i][j] = val[itemIndex] + maxRemain;
			}

			// CASE 2
			dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
		}
	}

	return dp[val.length][k];

}