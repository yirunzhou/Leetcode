
**Space**
	
	from helper function

	from result's head and tail

		and we make sure that there will not be space in the middle of the result


**be sure to update loop variable in while or just use a for loop**




```

class Solution {


	1			234						098				012

	+billion		+million			tho				""


	/1_000_000_000
	%

	/1_000_000
	%

	/1_000
	%

	/1
	%1

	->0->terminate


	in each block 

	-> space

	-> get x < 1000 english word, append
	
	-> space

	-> "b/m/t/", append


	get x < 1000 english word : helper(int x)

		x < 20 -> LESS_20
		x < 100 -> TEN[x /10] + LESS_20[x%10]
		x < 1000 -> LESS_20[x/100] + " hun " + helper(x % 100);

		trim it before return


	corner:

		0

		1 000 123 134

	_one billion_one hundred and twnety three thousand_one hundred and thirty four

	

	int[] radix;		(1_000_000_000, )
	String[] thousands;	("b", "m", "t", "")
	String[] tens;		(20, 30 ...)
	String[] less_20;	(0 -> "")



    public String numberToWords(int num) {

    	if(num == 0){
    		return "Zero";
    	}

    	StringBuilder result = new StringBuilder();


    	for(int i = 0; i < radix.length; i ++){

    		int block = num / radix[i];

    		if(block != 0){

    			result.append(" ");

    			result.append(helper(block));

    			result.append(" ");

    			result.append(thousands[i]);
    		}

    		num %= radix[i];
    	}

    	return result.toString().trim();
    }


    private String helper(int x){
    	String result = "";

    	if(x < 20){

    		result = less_20[x];

    	} else if (x < 100){

    		result = tens[x/10] + " " + less_20[x%10];

    	} else {

    		// 100<= x < 1000

    		result = less_20[x / 100] + " Hundred " + helper(x % 100); 
    	}

    	return result.trim();
    }

}


// consider the negative

	public String numberToWordsWithNegative(int num){

		if(num == 0{
			return "Zero";
		}

		StringBuilder result = new StringBuilder();

		if(num < 0){
			result.append("Negative ");
		}


		long numl = Math.abs((long)num);



		for(int i = 0; i < radix.length; i ++){

    		int block = (int)(numl / radix[i]);

    		if(block != 0){

    			result.append(" ");

    			result.append(helper(block));

    			result.append(" ");

    			result.append(thousands[i]);
    		}

    		numl %= radix[i];
    	}

    	

    	return result.toString().trim();
	}