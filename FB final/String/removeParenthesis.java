


public class RemoveParenthesis{
	
	public int remove(String input) {
		
		int removeL = 0;	// the left to remove [0, i)
		int removeR = 0;	// the right to remove [0, i)
		
		
		/**
		 * 		case 1 (
		 * 
		 * 			removeL ++
		 * 				means we have unmatched (
		 * 
		 * 		case 2 )
		 * 			
		 * 			if(removeL >0) we have ( can match:
		 * 				removeL --
		 *  		else :
		 *  			removeR++
		 *  	
		 *  
		 * */	
		
	}
	
	public String removeInvalid(char[] input) {
		
		int counter = 0;
		
		/**			0	1	2	3	4	5	6	7
		 * 			(	(	)	)	)	(	(	)	
		 * 		
		 * 		c	1	2	1	0	r	1	2	1	
		 * 		
		 * 		c								
		 * 			0	1	2	1		r	0	1			
		 *		
		 *			(	(	)	)			(	)
		 *
		 * */
		
		
		
		
		
	}
	
	
	
}