```


	

	K = 2
	A	A	A	B	B	C	D



	A	B	C	

				i
	22	23	24	25
		1	1	2


	time = 3

	counter = 0


	A	B	C	D	A	B	_	A

	A	B	C	A	B	D	A



	1.in each interval

		case1: no task left -> 
					case 1.1 nothing left -> break
					case 1.2 append cd

		case2: have task left -> append task 

	terminate when counter == k + 1, aka, we reached the end of the interval

	2.sort the array

	3.do1,2 until there is nothing left




class Solution {
    public int leastInterval(char[] tasks, int n) {
	
		int[] occ = new int[26];

		for(char task : tasks){

			occ[task - 'A'] ++;

		}

		int time = 0;

		Arrays.sort(occ);

		while(!nothingLeft(occ)){

			// counter for a cd interval
			int counter = 0;

			int i = 25;

			while(counter < n + 1){

				if(needCD(occ, i)){
					
					if(nothingLeft(occ)){
						return time;
					}

					int extraCD = k + 1 - counter;

					time += extraCD;

					break;
				}

				occ[i] --;

				i --;

				counter ++;

				time ++;
			}


			Arrays.sort(occ);

		}

		return time;
    }


    private boolean nothingLeft(int[] occ){
    	return occ[25] == 0;
    }

    private boolean needCD(int[] occ, int i){
    	if(i < 0 || occ[i] == 0){
    		return true;
    	}

    	return false;
    }


}