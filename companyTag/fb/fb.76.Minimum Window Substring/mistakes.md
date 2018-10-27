

1. outer loop is for `lo`

2. when break from the inner while loop, before updating result, judge if `counter == 0`

3. when the difference could be 1, then check lo < hi, as the target string may have just one char, and the substring we are processing is [lo, hi) where `lo == hi`, aka, `""`,

thus, next we move lo, and lo > hi, cause error, thus we need a `lo <= hi` in the outer loop


4. check, can I enter this loop


/*		
	A	D	O	B	E	C	O	D	E	B	A	N	C


														lo
														hi


	counter = 2

	ADDE

	result = DEBA





	


*/



