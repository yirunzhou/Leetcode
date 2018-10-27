
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

    private int readCnt = 0;


    public int read(char[] buf, int n) {
        
    	int count = 0;

    	while(count < n){

    		if(tempP >= readCnt){

    			tempP = 0;
    			readCnt = read4(temp);

    		}

    		if(readCnt == 0){
    			break;
    		}

    		int shouldCopy = Math.min(readCnt - tempP, n - count);

    		for(int i = 0; i < shouldCopy; i ++){

    			buf[count ++] = temp[tempP ++];

    		}

    	}

    	return count;

    }
}