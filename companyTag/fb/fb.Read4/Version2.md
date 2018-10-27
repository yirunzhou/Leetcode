



```

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */


     private char[] temp = new char[4];

     private int tempP = 0;

     private int readLen = 0;


    public int read(char[] buf, int n) {

    	int bufP = 0;


    	while(bufP < n){

    		if(tempP >= readLen){
    			readLen = read4(temp);
    			tempP = 0;
    		}

    		if(readLen == 0){
    			break;
    		}

    		int shouldCopy = Math.min(readLen - tempP, n - bufP);

    		for(int i = 0; i < shouldCopy; i ++){

    			buf[bufP ++] = temp[tempP ++];

    		}

    	}

    	return bufP;
    }
}