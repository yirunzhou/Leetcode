

public class Write{

	public char[] buffer;

	public int w;

	public int r;

	private int size;

	public int canReadCnt;

	public int canWrite;

	public Write(int size){

		buffer = new char[size];
		w = 0;
		r = 0;

		this.size = size;
		canReadCnt = 0;

		canWrite = size;

	}
	/**


	read				j
	write	i
			a	b	c	d	e	


write -> copy, move i
		
		if reach end, then stop, reset the pointer to 0
		if reach read pointer(not 0), stop




	read -> copy to result

		if reached end, see if write is not 0
			if not 0
				then set j to 0, continue to read
		
	*/




	public int read(char[] dest, int n){

		int destCnt = 0;

		while(destCnt < n && canReadCnt != 0){


			int shouldCopy = Math.min(
							Math.min(canReadCnt, n - destCnt), 
							size - r);

			// copy to dest
			for(int i = 0; i < shouldCopy; i++){

				dest[destCnt ++] = buffer[r ++];

			}

			

			if(r == size){
				r = 0;
			}


			canReadCnt -= shouldCopy;

			canWrite += shouldCopy;

		}

		return destCnt;
	}

	// return the number of character we write into the queue
	public int write(char[] input){

		int count = 0;

		int fileLen = input.length;

		while(count < fileLen && canWrite != 0){


			int shouldWrite = Math.min(fileLen - count, Math.min(size-w, canWrite));

			for(int i = 0; i < shouldWrite; i ++){

				buffer[w ++] = input[count ++];

			}

			if(w == size){
				w = 0;
			}

			canRead += shouldWrite;
			canWrite -= shouldWrite;
		}

		return count;

	}








	public int read(char[] destination, int n){

		int count = 0;

		while(count < n && canReadCnt != 0){

			
			int shouldCopy = 0;

			/**
				Bound by n - count, size - r, canRead
			*/

			shouldCopy = Math.min(size - r, n - count);

			shouldCopy = Math.min(shouldCopy, canReadCnt);

			for(int i = 0; i < shouldCopy; i ++){
				destination[count++] = buffer[r++];
			}

			if(r == size){
				r = 0;
			}

			// Update after read

			canReadCnt -= shouldCopy;
			canWrite += shouldCopy;
			
		}



		System.out.printf("Read file(%d) : ", n);
		
		for(char c : destination){
			System.out.print(c + " ");
		}

		System.out.printf(", return %d\n", count);

		printBuffer();


		return count;
	}


	/**

		0	1	2	3	4	5
				w

		y	z	c	d	e	x
		
				r

		
		canRead = 6

		canWrite = 0

		write (xyz) :

			count = 1

			shouldwrite = min (3-1, 6-0, 2) -> 2

			copy(2)
		
			count = 3

	*/




	private void printBuffer(){
		System.out.printf("Now the buffer is : ");

		for(char c : buffer){
			System.out.print(c + " ");
		}

		System.out.println();

		System.out.println();


	}





	/**
	


	*/

	public int write(char[] writeFile){

		int fileLen = writeFile.length;


		int count = 0;


		while(count < fileLen && canWrite != 0){

			int shouldWrite = 0;

			shouldWrite = Math.min(fileLen - count, size - w);

			shouldWrite = Math.min(shouldWrite, canWrite);

			for(int i = 0; i < shouldWrite; i ++){
				buffer[w ++] = writeFile[count ++];
			}

			if(w == size){
				w = 0;
			}

			canWrite -= shouldWrite;

			canReadCnt += shouldWrite;

		}


		System.out.print("Write file : ");
		
		for(char c : writeFile){
			System.out.print(c + " ");
		}

		System.out.printf(", return %d\n", count);


		printBuffer();



		return count;


	}



	public int write2(char[] writeFile){

		int fileLen = writeFile.length;

		int count = 0;

		while(count < fileLen && canWrite != 0){

			int shouldWrite = 0;

			// do not override can read character
			if(w == r && canReadCnt != 0){
				break;
			}

			// then restricted by r
			if(canReadCnt != 0){

				if(w <= r){
					shouldWrite = Math.min(r - w, fileLen - count);
				} else {
					shouldWrite = Math.min(size - w, fileLen - count);
				}

			} else {
			// not restricted by r

				shouldWrite = Math.min(size - w, fileLen - count);

			}


			shouldWrite = Math.min(shouldWrite, canWrite);
			

			for(int i = 0; i < shouldWrite; i ++){
				buffer[w ++] = writeFile[count ++];
			}

			if(w == size){
				w = 0;
			}

			canWrite -= shouldWrite;

			canReadCnt += shouldWrite;

		}







		System.out.print("Write file : ");
		
		for(char c : writeFile){
			System.out.print(c + " ");
		}

		System.out.printf(", return %d\n", count);


		printBuffer();

		return count;
	}



	private static final char[] test1 = {'a', 'b', 'c'};

	private static final char[] test2 = {'d', 'e', 'f'};

	private static final char[] test3 = {'x','y','z', 'a', 'b', 'c'};




	public static void main(String[] args) {
		Write write = new Write(5);

		

		write.write(test2);

		write.write(test2);
		write.write(test2);
		write.write(test3);
		

		//	a	b	c

		write.write(test2);

		// 	a	b	c	d	e	


		write.read(new char[5], 3);

		// a	b	c	d	e	


		write.write(test3);


		//	x	y	z	d	e

		write.read(new char[5], 6);

		write.write(test2);

		write.write(test3);

		write.read(new char[5], 2);

		write.write(test3);

		write.write(test3);




	}
}


/**
	
	r
					w
	0	1	2	3	4	
	x	y	z	d	e


	write (abc)
		canReadCnt = 3
	
	write (def)

		w pointer reached end -> reset
		canreadCnt += 2 = 5

		r == w, break

	read (3)

		canRead != 0 = 5

			read 
		
		canRead -= 3 = 2

	write (xyzabc)

		write until w == r

		canRead += 3

	read (8)

		read until end -> canRead -= 2, canRead > 0, set r to 0, continue read

		until reached write



		
	


 []write([abc]) =>3 


	 r	   w	
	[a b c . .] write([def]) =>2 // 因为buffer满了，所以只能写进两个char

	[a b c d e] read(3)=>[a b c] / 3

	[. . . d e] write([xyzabc]) => 3

	[x y z d e] 

	read(8)==>[d e x y z]  // 注意这个地方d e 先读出来是因为这两个是先被write进去的, 有先后关系

	# corner case: [. a b . .]

	*/

