```

	radix
	thousands
	tens
	less_20


	1	_	2	3	4	_	0	8	9	_	1	1	2

	/1billion
	%1billion

	/1m
	%1m

	/1k
	%1k

	/1
	%1

	-> get block < 1000

	if block != 0 

		use a method to get E of block 

		append "b/m/t/nothing" behind

		mind space

	modify x

	iterate above





public String ItoE(int x){

	if(x == 0){
		return "Zero";
	}

	StringBuilder result = new StringBuilder();


	for(int i = 0; i < radix.length; i ++){

		int block = x / radix[i];

		if(block != 0){
			result.append(" ");

			result.append(helper(block));

			result.append(" ");

			result.append(thousands[i]);
		}

		x %= radix[i];
	}


	return result.toString.trim();

}


private String helper(int x){
	String result = "";

	if(x < 20){

		result = less_20[x];

	} else if(x < 100){

		result = tens[x/10] + " " + less_20[x%10];

	} else {

		result = less_20[x/100] + " Hundred " + helper(x % 100);
	}

	return result.trim();

}