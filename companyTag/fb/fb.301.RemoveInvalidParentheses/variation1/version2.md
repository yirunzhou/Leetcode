```

	0	1	2	3	4	5
	(	(	(	)	)	(


	0	1	2	3	4	5
	(	(	(	(	)	)
							end
		lo
hi

	lo - [0, lo) we keep

	hi - [hi, len-1] need to process



	first round:

		left -> counter ++
		right -> counter --

		if not valid then not write

		record -> end = lo



	second round:

		right->counter ++
		left -> counter --
		
		if not valid ...


	return [lo, end]



public static String delete(String input){

	char[] c = input.toCharArray();

	int lo = 0;
	int hi = 0;
	int counter = 0;

	while(hi < c.length){

		if(c[hi] == '('){
			counter ++;

			c[lo] = c[hi];

			lo ++;
			hi ++;
		} else {

			if(counter == 0){

				hi ++;
			} else {

				counter --;
				c[lo] = c[hi];
				lo ++;
				hi ++;
			}
		}
	}

	int end = lo;

	lo = end-1;
	hi = end-1;
	counter = 0;

	while(hi >= 0){

		if(c[hi] == ')'){

			counter ++;

			c[lo] = c[hi];
			lo --;
			hi --;

		} else {

			if(counter == 0){
				hi --;
			} else {

				counter --;
				c[lo] = c[hi];
				lo --;
				hi --;
			}
		}
	}

	StringBuilder result = new StringBuilder();

	for(int i = lo; i < end; i ++){
		result.append(c[i]);
	}

	return result.toString();
}