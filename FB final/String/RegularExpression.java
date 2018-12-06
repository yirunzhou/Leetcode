
public class RegularExpression {
	
	
	public boolean isMatch(String s, String p) {
		/*
	s:		0	1	2	3	4	5
				a	b	a	a	a
	p:	
	0		t	f	f	f	f	f	
	1	.	f	t	f	f	f	f
	2	b	f	f	t	f	f	f
	3	a	f	f	f	t	f	f
	4	*	f	f	t	t	t	t
	5	.	f	f	f	t	t	t
	
	
	CASE 1: NOT *
		. or normal char -> compare current, and see  dp[i-1][j-1]
		
	CASE 2: *
	
		if not match with previous letter of *:
		 	only hope is * means 0 time
		 	
		else match:
		
			0. * is 0 times of p[i-1] -> look at dp[i-2][j]
			
				2. 1 time -> dp[i-1][j]
				3. 2 times -> dp[i-1][j-1]
				3. 3 or more -> dp[i][j-1]
				
		
						i
			.	b	a	*
						j
		a	b	a	a	a
		
		*
		*
		*/
		
		boolean[][] dp = new boolean[p.length+1][s.length+1];
		
		/* get info about empty s matches p or not
		 	
		 	dp[i=0->p.len][0]
		 	
		  empty p matches s ?
		  	dp[0][j=0->s.len]
		 *
		 */
		init(dp, s, p);
		
		
		for(int i = 1; i < dp.length; i ++) {
			for(int j = 1; j < dp[0].length; j ++) {
				
				int y = i-1; // -> pointer of p
				int x = j-1; // ->pointer of s
				
				if(p.charAt(y) == '*') {
					// first, when charAt y-1 != x, only hope is * represent 0 time
					
					if(p.charAt(y-1) != '.' && s.charAt(x) != p.charAt(y-1)) {
						
						dp[i][j] = dp[i-2][j];
						
					} else {
						
						/**
						 * 	0. * is 0 times of p[i-1] -> look at dp[i-2][j]
			
							1. 1 time -> dp[i-1][j]
							2. 2 or more times -> dp[i][j-1]
							
						 * */
						
						dp[i][j] = dp[i-2][j] || dp[i-1][j] ||dp[i][j-1];
						
					}

				} else {
					// normal char or .
					
					if(p.charAt(y-1) != '.' && s.charAt(x) != p.charAt(y-1)) {
						dp[i][j] = false;
					} else {
						dp[i][j] = dp[i-1][j-1];
					}
					
				}
				
			}
			
		}
		
		return dp[p.length][s.length];
		
	}
	
	private void init(boolean[][] dp, String s, String p) {
		
		dp[0][0] = true;
		
		// empty s matches p or not 
		
		for(int i = 1; i < dp.length; i ++) {
			
			int y = i-1;
			
			if(p.charAt(y) == '*') {
				
				dp[i][0] = dp[i-2][0];
				
			}
		
		}
		
		// empty p always mismatch with non empty s
		
	}

}
