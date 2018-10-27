
CATCH: for loop's start is 0 or 1? out of bound ?

|| or &&

```
public boolean regularExpressionMatch(String s, String p){

	if(s == null || p == null){
		return false;
	}


	// dp[i][j] means s[0,i-1] matches p[0,j-1] or not
	
	boolean[][] dp = new boolean[s.length()+1][p.length()+1];


	// empty s matches p[0, i-1]?

	init(s, p, dp);


	for(int i = 1; i < dp.length; i ++){
		for(int j = 1; j < dp[0].length; j ++){

			int x = i-1;
			int y = j-1;

			// x is s pointer, y is p pointer

			// i x  abccc
			// j y  abd

			if(p.charAt(y) != '.' && p.charAt(y) != '*'){
				if(s.charAt(x) == p.charAt(y)){
					dp[i][j] = dp[i-1][j-1];
				}
			} else if(p.charAt(y) == '.'){
				dp[i][j] = dp[i-1][j-1];
			} else {
				// * 

				// what * represent doesnt matches s.charAt(x)

				// i x  abc
				// j y  abi*

				if(p.charAt(y-1) != s.charAt(x) || p.charAt(y-1) != '.'){
					dp[i][j] = dp[i][j-2];
				}


				// then * represents the same char as s.charAt(x)

				// * stands for 1 times

				// i x abbbc
				// j y abbbc*

				// * stands for 2 times

				// i x abbbcc
				// j y abbbc*

				// * stands for 3 times -> so on

				// i x abbbccccccc
				// j y abbbc*


				else {

					dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i][j-2];

				}

			}

		}
	}


	return dp[s.length()][p.length()];
}



private void init(String s, String p, int[][] dp){

	// empty matches empty

	dp[0][0] = true;


	// empty string matches p[0, i-1] or not


	// j y s* -> matches -> = dp[0][0]

	// j y s*b* -> matches -> = dp[0][2]


	for(int j = 1; j < dp[0].length; j ++){

		int y = j -1;

		if(p.charAt(y) == '*'){
			dp[0][j] = dp[0][j-2];
		}
	}

}






