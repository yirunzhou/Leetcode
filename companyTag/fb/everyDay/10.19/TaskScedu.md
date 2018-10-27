
```

1.	sort the freq

2.	counting time

3. 	in each interval of n, start picking from the most freq one
		
		after reach the end of the interval, sort the freq

		if freq's largest is 0, then quit


		A	A	A	B	C	D	

		n = 2

		A	B	C	

		COUNTER = 3

		TIME = 3


public int leastInterval(char[] tasks, int n) {


	int[] freq = new int[26];

	for(char c : tasks){
		freq[c - 'A'] ++;
	}

	Arrays.sort(freq);

	int time = 0;

	while(!isEmpty(freq)){

		// interval counter
		int counter = 0;

		// picking up task
		int pointer = 25;

		while(counter <= n){

			if(isEmpty(freq)){
				break;
			}

			if(!needCd(freq, pointer)){
				freq[pointer] --;
				pointer --;
			}

			time ++;
			counter ++;
		}

		Arrays.sort(freq);

	}

	return time;
}


private boolean isEmpty(int[] freq){
	return freq[25] == 0;
}

private boolean needCd(int[] freq, int pointer){

	if(pointer < 0 || freq[pointer] == 0){
		return true;
	}

	return false;
}


1.	put task into queue

2.	in each interval

		if nothing left in queue and list, break
		
		if queue not empty, poll from queue(most freq task)

			update it freq, put into temp list


	when end, add list elem into queue -> (sort)

	when nothing left in queue, terminate


public int leastInterval(char[] tasks, int n) {

	int[] freq = new int[26];

	for(char c : tasks){
		freq[c - 'A'] ++;
	}


	PriorityQueue<Pair>	queue = new PriorityQueue<>(new PairComparator());

	for(int i = 0; i < 26; i ++){
		if(freq[i] != 0){
			queue.offer(new Pair(char('A' + i), freq[i]));
		}
	}

	int time = 0;

	StringBuilder sequence = new StringBuilder();

	while(!queue.isEmpty()){

		int counter = 0;

		List<Pair> temp = new ArrayList<>();

		while(counter <= n){

			// have other availiable tasks to pick in the interval
			
			if(!queue.isEmpty()){

				sequence.append(queue.peek().task);

				if(queue.peek().freq > 1){
					queue.peek().freq -= 1;
					temp.add(queue.poll());
				} else {
					queue.poll();
				}

			} else {
				sequence.append("_");
			}

			// if jump to this without doing if, means no av task, cd
			counter ++;
			time ++;

			if(queue.isEmpty() && temp.size() == 0){
				break;
			}

		}

		for(Pair p: temp){
			queue.offer(p);
		}

	}

	System.out.println(sequence);

	System.out.println(sequence.length());

	return time;

}

private class Pair{
	char task;
	int freq;

	public Pair(char t, int f){
		task = t;
		freq = f;
	}
}


private class PairComparator implements Comparator<Pair>{
	@Override
	public int compare(Pair p1, Pair p2){
		return p2.freq - p1.freq;
	}
}

