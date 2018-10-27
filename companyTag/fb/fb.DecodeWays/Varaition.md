```

A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.



* -> 1-9	->	9

0* -> 			0
1* -> 11-19	->	9
2* -> 21-26	->	6

3*				0
...


	one way

		case1 : s[i] is normal

			if s[i] != '0' dp[i] = dp[i-1]

		case2 : * 1-9

			dp[i] = dp[i-1] * 9


	two way

		case1: s[i], s[i-1] are both *

			dp[i] += dp[i-2] * 15

		case2: only s[i] is *

			2.1	s[i-1] is '1'	dp[i] += dp[i-2] * 9

			2.2 s[i-1] is '2'	dp[i] += dp[i-2] * 6

		case3: only s[i-1] is *

			3.1	s[i] <= 6		dp[i] += dp[i-2] * 2
			3.2 s[i] >	6		dp[i] += dp[i-2] * 1

		case4: both are not *

			in range [10, 26]   dp[i] += dp[i-2]



		dp[i] %= 1000000007




dp[i] -> s[0, i-1]'s decoding ways

dp[len] -> s[0, len-1] -> result



class Solution {

    public int numDecodings(String s) {
        
    	if(s == null || s.length() == 0){
    		return 0;
    	}

    	int[] dp = new int[s.length()+1];

    	dp[0] = 1;

    	if(s.charAt(0) == '0'){
    		return 0;
    	}

    	dp[1] = s.charAt(0) == '*' ? 9 : 1;


    	for(int i = 2; i < dp.length; i ++){

    		int j = i - 1; // -> point to dp[i]'s char

    		char frist = s.charAt(j-1);

    		char second = s.charAt(j);


    		// one way


    		if(second == '*'){
    			dp[i] = dp[i-1] * 9;
    		} else {
    			if(second != '0'){
    				dp[i] = dp[i-1];
    			}
    		}

    		// Two way


    		if(first == '*' && second == '*'){

    			dp[i] = dp[i-2] * 15;

    		} else if(first == '*'){

    			if(second <= '6'){

    				dp[i] += dp[i-2] * 2;

    			} else {

    				dp[i] += dp[i-2];

    			}

    		} else if(second == '*'){

    			if(first == '1'){

    				dp[i] += dp[i-2] * 9;

    			} else if(first == '2'){

    				dp[i] += dp[i-2] * 6;

    			}

    		} else {

    			int twoDigit = (first - '0') * 10 + (second - '0');

    			if(twoDigit >= 10 && twoDigit <= 26){

    				dp[i] += dp[i-2];

    			}

    		}

    		dp[i] %= 1000000007;

    	}


    	return dp[s.length()];


    }



}

