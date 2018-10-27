```

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */


      	0	1	2	3	4	5
    	c	b	a	d	e	f

	    				i
   temp	c	b	a	d

   buf  d


	    	i
   temp	e	f	-> read4(return 2

   				j -> have enough -> return 2
   buf  d	e


    n = 3

    	return 3
    	
    n = 2



    temp	-> read4()
    tempP	-> [tempP, 3] is remaining chars from temp

    buf		->	detination
    bufP	->	[0, bufP) is we have colleted	->number of chars collected




readN:

    bufP < n :

    	tempP < readLen:
    		copy sth from temp to buf, update bufP, tempP
    		until tempP >=readLen || bufP >= n

    	if bufP >= n
    		break

    	else 
    		readLen = read4(temp)
    		tempP = 0


    	if(readLen == 0)
    		break;
    	


    return bufP


test:
		0	1	2	3	4	5
file	a	b	c	d	e	f
		
				i
		0	1	2	3	
temp	e	f

						j
		0	1	2	3	4	5
buf		c	d	e	f

readLen = 2



1.read(2)

		read4

		return 2
		
2.read(6)
		return 4



public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    /**
    readN:

    bufP < n :

    	tempP < readLen:
    		copy sth from temp to buf, update bufP, tempP
    		until tempP >=readLen || bufP >= n

    	if bufP >= n
    		break

    	else 
    		readLen = read4(temp)
    		tempP = 0


    	if(readLen == 0)
    		break;
    	


    return bufP



    */


    a	b	c



    i
    0	1	2	3
tempa	b	c


	j
	0	1	2	3
buf	





    private  char[] temp = new char[4];

    private  int tempP = 0;

    private  int readLen = 0;



    public int read(char[] buf, int n) {
        
    	int bufP = 0;

    	while(bufP < n){


    		// have something to copy
    		// need to copy something
    		// then copy
    		while(tempP < readLen && bufP < n){

    			buf[bufP] = temp[tempP];

    			bufP ++;
    			tempP ++;

    		}

    		// do not need to copy
    		if(bufP >= n){
    			break;
    		}

    		// need to copy something
    		readLen = read4(temp);

    		tempP = 0;

    		if(readLen == 0){
    			break;
    		}
    	}

    	return bufP;

    }
}



