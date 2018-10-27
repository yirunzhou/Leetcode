```

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Example 1:

Input: buf = "abc", n = 4
Output: "abc"
Explanation: The actual number of characters read is 3, which is "abc".
Example 2:

Input: buf = "abcde", n = 5 
Output: "abcde"
Note:
The read function will only be called once for each test case.



/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/**

n = 5
		
file 	a	b	c	d	e	f	g

			j
temp 	e	f	g
							i
buf		a	b	c	d	e

readCount = 4

read4*1

[0, j) is has copied in temp
[0, i) ...in buf

readCount - last time the return val of read4()





while still need to copy :

	if nothing in temp can copy
		read4
		update j, readCount

	if end of file
		break

	shouldCopy = Math.min(n - i, readCount - j);

	copy shouldCopy chars

*/


public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    public int read(char[] buf, int n) {
        
        char[] temp = new char[4];

        int tempP = 0;

        int bufP = 0;

        int readCnt = 0;


        while(bufP < n){

        	// tempP reached the end -> read
        	if(tempP >= readCnt){
        		readCnt = read4(temp);
        		tempP = 0;
        	}

        	// eof
        	if(readCnt == 0){
        		break;
        	}

        	// calc
        	int shouldCopy = Math.min(n - bufP, readCnt - tempP);

        	// copy
        	for(int i = 0; i < shouldCopy; i ++){
        		temp[tempP++] = buf[bufP++];
        	}

        }

        return bufP;
    }
}


/**
	mutiple times

	so we need to preserve temp, tempP, readCnt

*/

private char[] temp = new char[4];
private int tempP = 0;
private int readCnt = 0;




public int read(char[] buf, int n) {

	int bufP = 0;

	while(bufP < n){

		if(tempP >= readCnt){
			readCnt = read4(temp);
			tempP = 0;
		}

		if(readCnt == 0){
			break;
		}

		int shouldCopy = Math.min(n - bufP, readCnt - tempP);

		for(int i = 0; i < shouldCopy; i ++){

			buf[bufP ++] = temp[tempP ++];

		}
	}

	return bufP;
}