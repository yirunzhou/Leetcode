


```

class Solution {
    public int numDecodings(String s) {

        if(s.length() == 0){
        	return 0;
        }

        int[] dp = new int[3];

        // dp[i] [0, i) decoding ways

        dp[0] = 1;

        if(s.charAt(0) == '0'){
        	return 0;
        }

        dp[1] = 1;

        // from charAt(1), search decoding ways
        for(int i = 2; i <= s.length(); i ++){

        	/**
				0	1	2	3
		input	1	2	2	7

		dp	0	1	2	3	4	
			1	1	2	3	3

        	*/

        	dp[i%3] = 0;

        	// decode one char way

        	char first = s.charAt(i-2);
        	char second = s.charAt(i-1);

        	// one char way

        	if(second != '0'){
        		dp[i%3] += dp[(i-1)%3];
        	}

        	// two char way

        	int digit = (first - '0') * 10 + (second - '0');

        	if(digit >= 10 && digit <= 26){

        		dp[i%3] += dp[(i-2)%3];

        	}

        }

        return dp[s.length()%3];

    }
}


```

Decoode Ways II

```

public int decodeWays(String s){

    if(s.length() == 0){
        return 0;
    }

    long[] dp = new long[s.length() + 1];

    dp[0] = 1;

    if(s.charAt(0) == '0'){
        return 0;
    }

    dp[1] = s.charAt(0) == '*' ? 9 : 1;

    
    for(int i = 2; i <= s.length(); i ++){

        char first = s.charAt(i-2);

        char second = s.charAt(i-1);

        if(second == '*'){
            dp[i] += dp[i-1] * 9;
        } else if(second != '0'){
            dp[i] += dp[i-1];
        }


        // decode two ways

        if(first == '*' && second == '*'){

            dp[i] += dp[i-2] * 15;

        } else if(first == '*'){

            // decode as 1
            dp[i] += dp[i-2];

            // decode as 2
            if(second < '7'){
                dp[i] += dp[i-2];
            }

        } else if(second == '*'){

            if(first == '1'){
                // 11 -> 19 
                dp[i] += dp[i-2] * 9;
            } else if(first == '2'){
                // 21 -> 26
                dp[i] += dp[i-2] * 6;
            }

        } else {
            // both are n

            int twoDigits = (first - '0') * 10 + (second - '0');

            if(twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i-2];
            }

        }

        dp[i] %= 10E9 + 7;

    }

    return (int)dp[s.length()];

}

