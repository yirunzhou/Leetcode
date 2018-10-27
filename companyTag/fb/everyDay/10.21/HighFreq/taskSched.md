taskSched.md

**be clear about the meaning of `time`**

**QUEUE SOLUTION: we need to look at previous N tasks, so when queue > N, we remove**



```


/* LC 621 original */

class Solution {
    public int leastInterval(char[] tasks, int n) {
    	/**
			n = 2
			A	A	A	B	B	C	D

			A	B	C	A	B	D	A

			1	2	3
					->break, process freq
			
			pick most frequent task in one interval

			after the interval end, we still need to pick the most frequent

    	*/

		int[] freq = new int[26];

		for(char c : tasks){
			freq[c - 'A'] ++;
		}

		Arrays.sort(freq);

		// number of tasks that has scheduled
		int time = 0;

		while(!isEmpty(freq)){

			int count = 0;

			int i = 25;

			// single cd interval
			while(!isEmpty(freq) && count <= n){

				if(freq[i] != 0){
					freq[i] --;
					i --;
				}

				time ++;
				count ++;

			}

			Arrays.sort(freq);

		}

		return time;

    }

    private boolean isEmpty(int[] freq){
    	return freq[25] == 0;
    }
}

/*
	Fix Sequence
	map Solution
*/


public static int leastInterval(char[] tasks, int k){

		Map<Character, Integer> lastOcc = new HashMap<>();

		// has scheduled time
		int time = 0;

		for(char task : tasks){
			
			while(needCd(task, lastOcc, k, time)){
				time ++;
			}

			lastOcc.put(task, time);
			time ++;

		}

		System.out.println(time);
		return time;

	}

	private static boolean needCd(char task, Map<Character, Integer> lastOcc, int k, int time){

		if(!lastOcc.containsKey(task)){
			return false;
		}

		int lastOccTime = lastOcc.get(task);

		if(time - lastOccTime > k){
			return false;
		}

		return true;
	}

/*
	Fix Sequence
	queue Solution
*/

	private static int spaceOpti(char[] tasks, int k){

	Queue<Character> queue = new LinkedList<>();
	Set<Character> set = new HashSet<>();

	//itera

	//if there is same task, push queue with null, until there is not
	// else push task

	int time = 0;

	for(char task : tasks){

		while(set.contains(task)){
			excute(null, queue, set, k);
			time ++;
		}

		excute(task, queue, set, k);
		time ++;
	}

	System.out.println("Queue and Set Solution: ");

	System.out.println(time);

	return time;

}

/**
	k = 2 -> keep a k+1 interval

	A	B	_	
size1	2	3	
*/

private static void excute(Character task, Queue<Character> queue, Set<Character> set, int k){
	
	System.out.printf("Excute %s\n", task + "");
	queue.offer(task);

	if(task != null){
		set.add(task);
	}

	if(queue.size() > k){

		Character peek = queue.poll();

		if(peek != null){
			set.remove(peek);
		}

	}


}


```