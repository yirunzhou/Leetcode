

import java.util.*;


public class Version1{
	// QUEUE, SET SOLUTION
	public static int spaceOpti1(char[] tasks, int k){

		int time = 0;

		Queue<Character> queue = new LinkedList<>();

		Set<Character> set = new HashSet<>();

		StringBuilder result = new StringBuilder();



		for(char c : tasks){

			while(set.contains(c)){

				result.append("_");

				excute(null, queue, set, k);

				time ++;

			}

			excute(null, queue, set, k);

			time ++;

			result.append(c);

		}



		System.out.println("Queue and Set Solution: ");
		System.out.println(result);

		System.out.println(time);

		return time;
	}

	private static void excute1(Queue<Character> queue, Set<Character> set, Character task, int k){

		queue.offer(task);

		set.add(task);

		if(queue.size() > k){
			Character peek = queue.poll();

			if(peek != null){
				set.remove(peek);
			}
		}

	}

	/**
	10.24
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


	// MAP SOLUTIONS
	public static int leastInterval1(char[] tasks, int k){

		// task - last occ
		Map<Character, Integer> map = new HashMap<>();

		int time = 0;
		//  k = 3
		//	0	1	2	3	4
		//				
		// 	A	_	_	_	A

		StringBuilder result = new StringBuilder();


		for(char c : tasks){

			if(map.containsKey(c)){

				int lastOcc = map.get(c);

				while(time - lastOcc <= k){

					result.append("_");

					time ++;
				}

			}


			result.append(c);

			map.put(c, time);

			time ++;

		}

		System.out.println(result);

		return time;

	}

	/**
		10.24
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



	/**							i
		A	A	C	D	A	B	A	C	D	D	A
	
	set: 	B
	q  :	B	_	_	

	A _	_ _	A	C	D	_	A	B	_	_


	*/



	public static void main(String[] args) {
		Version1.leastInterval(args[0].toCharArray(), Integer.valueOf(args[1]));
		Version1.spaceOpti(args[0].toCharArray(), Integer.valueOf(args[1]));
	}

	

/*

	public static int leastIntervalOriginal(char[] tasks, int k){

		// lastApp
		Map<Character, Integer> map = new HashMap<>();

		// index we are trying to add task, [0, curTime) is we have arranged
		int curTime = 0;

		StringBuilder result = new StringBuilder();

		for(char task : tasks){

			Integer lastApp = map.get(task);

			if(lastApp != null && curTime -1 - lastApp < k){

				int curCD = curTime-1 - lastApp;

				int extraCD = k - curCD;

				for(int i = 0; i < extraCD; i ++){
					result.append("_");
				}

				curTime += extraCD;

			}

			result.append(task);

			map.put(task, curTime);

			curTime += 1;

		}

		System.out.println("HashMap Solution: ");

		System.out.println(result);

		System.out.println(curTime);

		// length of the result
		return curTime;
	}

	*/
}