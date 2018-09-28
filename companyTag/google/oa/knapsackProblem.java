
public class knapsackProblem{
	// k is capacity
	public static int knapsack(int[] val, int[] weight, int k){
		if(val == null || val.length == 0){
			return 0;
		}

		int[][] dp = new int[val.length+1][k+1];

		for(int i = 1; i < dp.length; i ++){ // loop through item
			for(int j = 0; j < dp[0].length; j ++){ // loop through capa

				int itemIndex = i - 1;

				// CASE 1
				if(j >= weight[itemIndex]){
					dp[i][j] = dp[i-1][j-weight[itemIndex]] + val[itemIndex];
				}

				// CASE 2
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
			}
		}

		return dp[val.length][k];
	}

	// return the min difference to distribute mission between two servers
	public static int distributeServer(int[] mission){
		if(mission == null) return 0;
		int sum = 0;
		for(int m : mission){
			sum += m;
		}
		int half = sum / 2;

		// row : 0, mission
		// col : [0, half]
		int[][] dp = new int[mission.length + 1][half+1];

		for(int i = 1; i < dp.length; i ++){
			for(int j = 0; j < dp[0].length; j ++){
				// mIndex is current mission
				// j is current capa
				int mIndex = i - 1;
				
				// CASE 1 : add mission[mIndex]
				if(j >= mission[mIndex]){
					dp[i][j] = mission[mIndex] + 
							   dp[i-1][j-mission[mIndex]];
				}

				// CASE 2 : not add
				dp[i][j] = Math.max(dp[i][j],
									dp[i-1][j]);
			}
		}

		int oneServer = dp[mission.length][half];
		return Math.abs(oneServer - (sum - oneServer));
	}

	public static void main(String[] args) {
		int[] val = {1, 4, 5, 9};
		int[] weight = {1, 3, 4, 5};
		// System.out.println(knapsackProblem.knapsack(val, weight, 7) == 10);	

		int[] mission = {1, 2, 1, 1, 9};
		System.out.println(knapsackProblem.distributeServer(mission));
	}
}