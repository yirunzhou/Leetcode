```



A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


		0	1	2	|0	1	2	
ways	2	2	3	|2	
		

						i
		0	1	2	3	4
s		2	2	6	2	1


	i = 3

	-> 3 % 3 -> 0

	-> 2 % 3 -> 2
	-> 1 % 3 -> 1

	i = 4

	-> i % 3 = 1

	-> i-1 % 3 = 0
	-> i-2 % 3 = 2



	i
	2	2	6	


	ways:
		2 -> 2 -> 6

		2 -> 26

		22 -> 6


	if we know the decode ways for i-1, i-2

	then we know the decode ways for i

	ways[i] = 

		CASE1 :
			decode in signle s[i]
			if s[i] != 0
			ways[i] = ways[i-1]

		CASE2 :
			decode in s[i-1,i]
			get the digits -> twoDigits

			if twoDigits in [10, 26]
			ways[i] += ways[i-2]


	init:

		ways[0]:
			s[0] != '0' -> ways[0] = 1

		ways[1]:

			s[1] != '0' -> ways[1] = ways[0]

			s[0, 1] -> get the digits -> twoDigits

			if twoDigits in [10, 26]
			ways[1] += 1




class Solution {
    public int numDecodings(String s) {
        
        if(s == null){
        	return 0;
        }

        if(s.length() < 2){
        	if(s.length() == 0){
        		return 0;
        	}
        	return s.charAt(0) == '0' ? 0 : 1; 
        }

        int[] ways = new int[3];


        //init

        init(s, ways);

        
        for(int i = 2; i < s.length(); i ++){

        	//case 1

        	if(s.charAt(i) != '0'){
        		ways[i%3] = ways[(i-1)%3];
        	}

        	//case 2

        	int twoDigits = Integer.valuOf(s.substring(i-1, i+1));

        	if(twoDigits >= 10 && twoDigits <= 26){
        		ways[(i)%3] += ways[(i-2)%3];
      	 	}


        }


        return ways[s.length()-1];

    }


    private void init(String s, int[] ways){
    	if(s.charAt(0) != '0'){
        	ways[0] = 1;
        }

        if(s.charAt(1) != '0'){
        	ways[1] = ways[0];
        }

        int twoDigits = Integer.valuOf(s.substring(0, 2));

        if(twoDigits >= 10 && twoDigits <= 26){
        	ways[1] += 1;
        }
    }
}