


public int TaskScheduler(char[] tasks, int n){
	if(tasks == null || tasks.length == 0){
		return 0;
	}
	int[] map = new int[25];
	for(char task : tasks){
		map[task-'A'] += 1;
	}

	int time = 0;
	boolean terminate = false;

	while(sortAndHasTasksLeft(map)){
		int i = 25;
		int cd = 0;

		while(cd-1 < n){
			map[i] -= 1;
			time += 1;
			cd += 1;
			i -= 1;

			if(noTaskLeft(map, i)){
				terminate = true;
				break;
			}
			if(needIdleTime(map, i)){
				time += (n+1-cd); 
				break;
			}
		}

		if(terminate){
			break;
		}

	}

	return time;
}

private boolean sortAndHasTasksLeft(int[] map){
	Arrays.sort(map);
	if(map[25] == 0){
		false;
	}
	return true;
}

private boolean noTaskLeft(int[] map, int i){
	if(i < 0){
		if(map[25] == 0){
			return true;
		}
	} else {
		if(map[i] == 0 && map[25] == 0){
			return true;
		}
	}
	return false;	
}

private boolean needIdleTime(int[] map, int i){
	if(i < 0){
		return true;
	} else {
		if(map[i] == 0){
			return true;
		}
	}
	return false;
}



