

/**

Want to get the max profit, thus we define the status as the max profit

then find out the restrictions:

    1. current spaces
    2. items



dp[i][j] -> means with items[0, i-1], weight[j], the max profit can gain


Two choices to reach the status:
    
    1. do not choose the current item, so in order to reach the weight j, we look at dp[i-1][j]

    2. choose the current item, V[i-1] + dp[i-1][j-A[i-1]]


Mistakes:

    when making the 2. choice, we should make sure that j-A[i-1] is in bound

    and always make sure your dp functions coordinate is in bound

*/


public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        int[][] dp = new int[2][m+1];
            
        for(int i = 1; i <= A.length; i ++){
            //  current item is A[i-1]
            for(int j = 0; j <= m; j ++){
                dp[i%2][j] = dp[(i-1)%2][j];
                if(j - A[i-1] >= 0){
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j-A[i-1]] + V[i-1], dp[i%2][j]);
                }
            }
        }
        
        int max = 0;
        
        for(int i = 0; i <= m; i ++){
            max = Math.max(max, dp[(A.length)%2][i]);
        }
        
        return max;
    }
}