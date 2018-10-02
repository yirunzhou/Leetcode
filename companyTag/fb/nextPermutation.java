public class nextPermutation{

}


/**
	1. scanning from the end, find the # that is strictly smaller than next one
	   	mark as target
	
	2. scan back, find the # stricly larger than target, but need to be smallest
		mark as swap

		if there is no stricly smaller one, then the last one is the swap
		
	
	*if there is no such target in 1, swap whole array
	*the latter part is non-increasing
	*but the first # is stricly larger than target

	*draw a pic

*/