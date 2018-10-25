

```


/*

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

	
	N=3

	A	A	A	B	C	B	A


	A	A	A	A	B	B	C


	A  	B 	C	_	A	B	_	_	A	_	_	_	A



	A	B	C	_

	counter = 3

	time = 3


	i
		23	24	25
		0	1	2


		noleftTask:

		i < 0 || occ[i] == 0


		nothingLeft:

		occ[25] == 0




	A	B	C	D	E	A

	counter = 3 

	counter < k + 1 -> need to append extraCD




	if(leftSomething)
	extraCD = k + 1 - counter



	A	4
	B	2
	C	1


	A  	B	C 	_	A3	B1	C0
	A	B	_	_	A2	B0	C0
	A	_	_	_	A1
	A				A0





	sort the occ

	
	choose from the most significant number 

	append

	choose next significant task

	append

	...

	when there is no task to choose but appended task is smaller than k



	reset the pointer


	K = 2

	A	A	A	B	C	D	E


	time = 6

	counter = 3

						i
	20	21	22	23	24	25

	0	0	0	0	0	1



	A	B	C	A	B	C	A


	1/ reach the end of the cd slot -> sort
	2/ have nothing left to chose -> append extraCD




*/


class Solution {
    public int leastInterval(char[] tasks, int n) {
        
    	int[] occ = new int[26];

    	for(char task : tasks){

    		occ[task-'a'] ++;

    	}

    	Arrays.sort(occ);

    	int time = 0;

    	while(!nothingLeft(occ)){

    		int counter = 0;

    		int i = 25;

    		// inside the cd time slot
    		while(counter < k + 1){

    			if(noTaskToAppend(occ, i)){
    				break;
    			}

    			// otherwise

    			time ++;

    			counter ++;

    			occ[i] --;

    			i --;
    		}


    		if(counter < k + 1){

    			if(nothingLeft(occ)){
    				break;
    			}

    			int extraCD = k + 1 - counter;

    			time += extraCD;
    		}

    		Arrays.sort(occ);

    	}

    	return time;

    }


    private boolean nothingLeft(int[] occ){
    	return occ[25] == 0;
    }


    private boolean noTaskToAppend(int[] occ, int i){
    	if(i == -1 || occ[i] == 0){
    		return true;
    	}
    	return false;
    }

}