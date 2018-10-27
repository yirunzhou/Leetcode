```

int[] radix
String[] less_20
String[] tens
String[] thousands


public String numberToWords(int x){

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

	return result.toString().trim();
}


// x < 1000

private String helper(int x){
	String result = "";

	if(x < 20){

		result = less_20[x];

	} else if(x < 100){

		result = tens[x/10] + " " + less_20[x%10];

	} else{

		result = less_20[x/100] + " Hundred " + helper(x % 100);

	}

	return result.trim();
}