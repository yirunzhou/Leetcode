
```

class Solution {
    public int racecar(int target) {
        

        Queue<Status> queue = new LinkedList<>();

        int level = 0;

        queue.offer(new Status(0, 1));

        while(!queue.isEmpty()){

        	Status cur = queue.poll();

        	if(cur.pos == target){
        		return level;
        	}

        	// A

        	int posA = cur.pos + cur.spd;
        	int spdA = cur.spd * 2;

        	queue.offer(new Status(posA, spdA));


        	// R

        	int posR = cur.pos;
        	int spdR = cur.spd > 0 ? -1 : 1;

        	queue.offer(new Status(posR, spdR));

        	level ++;
        }

        return level;
    }


    private class Status{

    	int pos;
    	int spd;

    	public Status(int p, int s){
    		pos = p;
    		spd = s;
    	}
    }
}