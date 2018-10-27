


```
/*
K = 3

							i
		A	A	B	C	B	C	D	E	
	   
		A	_	_	_	A	B	C	_	_	B


time = 
counter = 


QUEUE: 	_	_	B

set: 	B


set-> check if the cool down contains current task,
	
	if contains -> add null into queue

	if not -> add current task into the set, queue


	if queue > k, pop the first, if not null, remove this from set

	time ++

*/



public int minInterval(char[] tasks, int k){

	int time = 0;

	Queue<Character> queue = new LinkedList<>();

	Set<Character> set = new HashSet<>();

	StringBuilder result = new StringBuilder();

	for(char c : tasks){

		while(set.contains(c)){

			queue.offer(null);

			time ++;

			result.append("_");


			if(queue.size() > k){

				Character pop = queue.pop();

				if(pop != null){
					set.remove(pop);
				}

			}

		}

		queue.offer(c);

		set.add(c);

		time++;

		result.append(c);

	}

	System.out.println(result);

	System.out.println(result.length() == time);

	return time;
}


