



public int mapSolution(char[] tasks){


	/**
		k= 2
		A	B	A	C	A	A	

		0	1	2	3	4	5
		A	B	_	A	C

		time = 2 -> time - lastocc -1 < k, need cd

		time = 3 -> time -.... == k, ok

		time = 5 -> time - ... < k, cd

		lastocc
				A	:	3
				B	:	1

				C	:	4

	*/


}


public int queueSolution(char[] tasks){

	/**	

		k= 2
		A	B	A	C	A	A	

		0	1	2 	3	
		A	B	_	A

	size shoudl be bound by 2


	queue null A
	*/


	Queue<Character> queue = new LinkedList<>();

	Set<Character> set = new HashSet<>();

	int time = 0;

	for(char task : tasks){

		while(set.contains(task)){
			execute(null, queue, set);
			time ++;
		}

		execute(task, queue, set);
		time ++;
	}

	return time;
}


/**
	null -> push into queue
	other -> push into queue, and add to set

	if size > k, poll from queue, if not null, delete that task from set

	-> O(1) to excute
*/

private void execute(Character task, Queue<Character> queue, Set<Character>){

	


}

