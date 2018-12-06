
/**

	If we know the # of distince subsequences of

	s[0, i-1], t[0, j-1]
	s[0, i-1], t[0, j]


	then we know the answer of i, j

	1. dp[i][j] = dp[i-1][j] -> means we do not look at current position of s, count for previous result

	2. if s[i-1]==t[j-1] : dp[i][j] += dp[i-1][j-1]
							
						-> last char is same, then we can count for s[0,i-2] t[0,j-2], which will be # of match of s[0,i-1] t[0,j-1]
	

	and 1, 2 do not overlap



	Mistakes:

		use dp[i][j-1] to calc the 2. possibility, then we overlap the use of current position of s
			e.g
				s: abb
				t: abb
				
				dp[i][j-1] = 2, and we have used last b of s for matching, even if the last char of s and t are the same,
				cannot say that dp[i][j] = 2, as we should look at dp[i-1][j-1] if i-1, j-1 position matches

		rolling index initialization:

		use two rows is enough, thus init with new int[2][t.length()+1]

		and dp[0][0] = 1, every loop should init dp[i][0] = 1


		
*/




class Solution {
    public int numDistinct(String s, String t) {
        
        if(s.length() < t.length()) return 0;
        
        int[][] dp = new int[2][t.length()+1];
        
        dp[0][0] = 1;
        
        for(int i = 1; i <= s.length(); i ++){
            
            dp[i%2][0] = 1;
            
            for(int j = 1; j <= i && j <= t.length(); j ++){
                
                dp[i%2][j] = dp[(i-1)%2][j];
                
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i%2][j] += dp[(i-1)%2][j-1];
                }
                
            }
        }
        
        return dp[s.length()%2][t.length()];

    }
}