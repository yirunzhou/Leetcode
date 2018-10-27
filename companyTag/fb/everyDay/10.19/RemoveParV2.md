

```

original	
	0	1	2	3	4	5	6	7	8
	(	(	)	)	) 	(	(	)	(


step1
	0	1	2	3	4	5	6	7	8
	(	(	)	)	( 	(	)	(	(

									i
										j

	counter = 2

step2
	0	1	2	3	4	5	6	7	8
	(	(	(	(	) 	)	(	)	(

		i
j

	counter = 0

public String removeInvalidParentheses(String s) {

	if(s == null || s.length() == 0){
		return "";
	}

	char[] c = s.toCharArray();


	int i = 0;
	int j = 0;

	int counter = 0;


	while(j < c.length){

		if(c[j] == '('){
			
			counter ++;

			c[i ++] = c[j ++]; 

		} else if (c[j] == ')'){

			if(counter == 0){
				j ++;

			} else {
				counter --;

				c[i ++] = c[j ++];
			}

		} else {

			c[i ++] = c[j ++];
		}

	}

	int end = i - 1;

	lo = end;
	hi = end;

	counter = 0;


	while(j >= 0){

		if(c[j] == ')'){
			counter ++;

			c[i --] = c[j --];

		} else if(c[j] == '('){

			if(counter == 0){

				j --;
			} else {

				counter --;

				c[i --] = c[j --];
			}

		} else {

			c[i --] = c[j --];
		}
	}

	// ans is (i, end]

	StringBuilder result = new StringBuilder();

	for(int iter = i + 1; iter <= end; iter ++){

		result.append(c[iter]);
	}

	return result.toString();
}