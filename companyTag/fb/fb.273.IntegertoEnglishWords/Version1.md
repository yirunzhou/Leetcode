```

Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"


	1_016	_203	_240


	-> 1	->	1 billion
	-> 16	->	16 Million
	-> 203	->	2 -> 2 hundred -> 3
	-> 240	->  2 -> 2 hundred -> 40 -> 4 -> fourty

	
	/ 1billion -> % 1 billion 
	/ 1million -> % 1 million
	...





	< 1000

	100 <= x < 1000

		hundred = x / 100

		self(x % 100)


	21 <= x <= 99

		ty = x / 10

		self(x % 10)


	0 < x <= 20

		return LESS_THAN_20[x]


	corner case : x == 0



String[] LESS_THAN_20 = {...};
String[] TENS = {...}
String[] THOUSANDS = {...};
int[] radix = {1_000_000_000, 1_000_000, 1_000, 1};

class Solution {
    public String numberToWords(int num) {
        
       if(num == 0){
       	return "Zero";
       }

		StringBuilder result = new StringBuilder();

       if(num < 0){
       	result.append("Negative");
       }

       long numl = Math.abs((long)num);

       int i = 0;
       
       while(numl > 0){

       		if(numl / radix[i] != 0){
       			
   				result.append(" ");
       			
       			result.append(helper((int)(numl / radix[i])));

       			result.append(" ");
       			result.append(THOUSANDS[i]);
       		}

       		numl %= radix[i];
       		i ++;
       }

       return result.toString().trim();
    }

    // x < 1000
    private String helper(int x){

    	String result = "";

    	if(x == 0){
    		result = "";
    	} else if (x < 20){
    		result = LESS_THAN_20[x];
    	} else if(x < 100){
    		result = TENS[x/10] + " " + LESS_THAN_20[x%10];
    	} else {
    		// 100 <= x < 1000
    		result = LESS_THAN_20[x/100] + " Hundred " + helper(x % 100);
    	}

    	return result.trim();
    }


    
}