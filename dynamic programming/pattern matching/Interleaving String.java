Interleaving String.java

/*
Mistakes:
	
	1. dp[i][j] is T[0, i+j-1] has subsequence of s1[0, i-1] and s2[0, j-1]

	2. dp[i][j] = dp[i-1][j] && T[i+j-1] == s1[i-1] ||
			   dp[i][j-1] && T[i+j-1] == s2[j-1]

	3. so init should have values that cannot be calcu by the induction rule,
	they are dp[0][k] and dp[k][0]

    4. rolling index with N, think about input amount smaller than N, will it be a problem
        it usually will be a problem, thus when traversing the dp array, should use input as 
        restriction, like :

            for(int i = 1; i <= s1.length(); i ++) ...

*/


public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        
        if(s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[2][s2.length()+1];
        
        dp[0][0] = true;
        
        String T = s3;
        
        /**
            dp[i][j] -> 
            
            [0, i + j) of T is interleave of subsequence of [0, i) and [0, j) of s1, and s2
            
            [0, i + j-1) of T is ... of [0, i) and [0, j-1) and T[i+j-1] == s2[j-1], or is [0, i-1) and [0, j)  and T[i+j-1] == s1[i-1]
            
            dp[i][j] = (dp[i][j-1] && T[i+j-1] == s2[j-1]) ||
                     (dp[i-1][j] && T[i+j-1] == s1[i-1])
                     
                     ps, the ith char of s1 is s[i-1]
                     
            init:
                first col and first row-> as we need dp[0][k] and dp[k][0], calculating this will out of boundary
         
        dp[i%2][0] = dp[(i-1)%2][0] && T.charAt(i-1) == s1.charAt(i-1)
           
        */
        
        
        for(int j = 1; j < dp[0].length; j ++){
            dp[0][j] = dp[0][j-1] && T.charAt(j-1) == s2.charAt(j-1);
        }
        
        for(int i = 1; i <= s1.length(); i++){

            dp[i%2][0] = dp[(i-1)%2][0] && T.charAt(i-1) ==  s1.charAt(i-1);

            for(int j = 1; j <= s2.length(); j ++){
                boolean matchS1 = T.charAt(i+j-1) == s1.charAt(i-1);
                boolean matchS2 = T.charAt(i+j-1) == s2.charAt(j-1);
                dp[i%2][j] = (dp[i%2][j-1] && matchS2) || (dp[(i-1)%2][j] && matchS1);
            }
        }
        
        
        return dp[s1.length()%2][s2.length()];
        
    }
}