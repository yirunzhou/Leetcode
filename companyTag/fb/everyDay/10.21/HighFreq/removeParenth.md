
1. hi ++ ? -- ?

2. final iteration [lo+1, end-1]

3. draw simple graph


	public String removeParenth(String input){

		char[] ch = input.toCharArray();

		int lo = 0;
		int hi = 0;

		int counter = 0;

		while(hi < ch.length){

			if(ch[hi] == '('){
				counter ++;

				ch[lo++] = ch[hi++];

			} else if(ch[hi] == ')'){

				if(counter == 0){

					hi ++;

				} else {
					counter --;

					ch[lo++] = ch[hi++];

				}

			}
		}


		int end = lo;

		/**
			// [0, lo) is valid for ')'
		hi
					lo	
						end
					
			(	(	(
		
			// record the end point
		*/

		lo = end -1;
		hi = end -1;

		counter = 0;

		while(hi >= 0){

			if(ch[hi] == ')'){
				counter ++;

				ch[lo --] = ch[hi --];

			} else {
				if(counter == 0){

					ch[hi --];

				} else {

					counter --;

					ch[lo --] = ch[hi --];
				}

			}

		}

		// (lo, end) is the valid parenth

		StringBuilder result = new StringBuilder();

		for(int i = lo+1; i < end; i ++){
			result.append(ch[i]);
		}

		return result.toString();

	}