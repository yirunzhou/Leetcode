* it is a 2d dp problem
* helper function need to write return type!
* index in the helper function need to match scope

```
public boolean regularExpressionMatch(String s, String p){
	if(s == null || p == null){
		return true;
	}

	boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	setUpDp(dp, s, p);

	for(int i = 1; i < dp.length; i ++){
		for(int j = 1; j < dp.length; j ++){
			updateDp(dp, s, p, i, j);
		}
	}

	return dp[s.length()][p.length()];
}

private void updateDp(boolean[][] dp, String s, String p, int i, int j){
	// update dp[i][j]
	// s[0 to x] matches p[0 to y] or not
	int x = i -1;
	int y = j -1;

	if(p.charAt(y) == '.'){
		dp[i][j] = dp[i-1][j-1];
	} else if(p.charAt(y) == '*'){
		if(p.charAt(y-1) != '.' || p.charAt(y-1) != s.charAt(x)){
			dp[i][j] = dp[i][j-2];
		} else {
			dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
		}
	} else {
		if(s.charAt(x) == p.charAt(y)){
			dp[i][j] = dp[i-1][j-1];
		}
	}
}

private void setUpDp(boolean[][] dp, String p){
	//empty matches empty
	dp[0][0] = true;

	// empty mateches p[0, y] or not?
	for(int j = 1; j < dp[0].length; j ++){
		int y = j-1;
		if(p.charAt(y) == '*'){
			dp[0][j] = dp[0][j-1];
		}
	}
}

```

0times
dp[i][j-2]
i abbc
j abbc.*

1time
dp[i][j-1]
i abbc
j abb.*

2 or more
dp[i-1][j]
i abbcc
j abb.*




