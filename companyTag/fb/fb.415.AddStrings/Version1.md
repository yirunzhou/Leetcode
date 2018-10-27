
```

class Solution {
	//  45
	// 987

	/*

		sum = 5 + 7 + carry

		carray = sum / 10
		add = sum % 10

		append



		corner cases: 

			carray is 1 after loop
			empty -> 0


	*/

	/**
	   p1
		16

	   p2
	   993

	   	sum = 9
	   	carray = 0
	   	append = 9

	   	---

	   	sum = 10
	   	carray = 1
	   	append = 0

	   	----

	   	sum = 9 + 1 = 10
	   	carray = 1
	   	append = 0

	   	---->	900

	   	append 1 -> 9001 -> 1009 = 16 + 993


	*/


    public String addStrings(String num1, String num2) {
        
    	int len1 = num1 == null ? 0 : num1.length;
    	
    	int len2 = num2 == null ? 0 : num2.length;

    	if(len1 == 0 && len2 != 0){
    		return num2;
    	}

    	if(len1 != 0 && len2 == 0){
    		return num1;
    	}

    	if(len1 == 0 && len2 == 0){
    		return "0"
    	}


    	int p1 = len1 - 1;
    	int p2 = len2 - 1;

    	int carray = 0;

    	StringBuilder result = new StringBuilder();

    	while(p1 >= 0 || p2 > =0){

    		int n1 = p1 >=0 ? nums1.charAt(p1) : 0;
    		int n2 = p2 >=0 ? nums2.charAt(p2) : 0;

    		int sum = n1 + n2 + carray;

    		carray = sum /10;

    		int append = sum % 10;

    		result.append(append);

    		p1 --;
    		p2 --;

    	}

    	if(carray == 1){
    		result.append('1');
    	}

    	result.reverse();

    	return result.toString();

    }
}