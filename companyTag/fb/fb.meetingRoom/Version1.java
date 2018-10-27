
/**
	



							----
				--------
			--------
	--------				
	-----------------------------
	0	1	2	3	4	5	6	7


		 			i	
	[0,2][2,4][3,5][6,7]


	pq[6,7]
	
	max = 2



							i
	[1,5],[8,9],[8,9] [9,10][10,11]

pq 
max = 2
	
	[1,5] -> 0
	[8, 9] -> 0
	[8, 9] -> 1
	

when add to target list, compare with the last item's end, if equals, merge




*/




public int minMeetingRooms(Interval[] intervals) {


	Arrays.sort(intervals, new StartComparator());


	// the meeting ends ealiest has the most priority
	PriorityQueue<Interval> pq = new PriorityQueue<>(new EndComparator());


	int max = 0;


	List<List<Interval>> meetingRoom = new ArrayList<>();


	for(Interval cur : intervals){

		while(!pq.isEmpty()){
            
            Interval endsFirst = pq.peek();
            
            if(endsFirst.end <= cur.start){
                
                pq.poll();
                
            } else{
                // the endsFirst's start is later than cur
                break;
                
            }
            
        }

        int index = pq.size();

        if(meetingRoom.size() == index){
        	meetingRoom.add(new ArrayList<Inteval>());
        }

        add(meetingRoom, cur, index);
        
        pq.offer(cur);
        
        max = Math.max(max, pq.size());

	}

	System.out.println(meetingRoom);

	return max;
}


private void add(List<List<Interval>> meetingRoom, Interval cur, int index){

	// add cur to end of mtrm[index]
	List<Interval> target = meetingRoom.get(index);

	if(target.size() == 0){
		// if there is no lastone
		target.add(cur);

	} else {

		Interval lastone = target.get(target.size()-1);

		if(lastone.end == cur.start){
			lastone.end = Math.max(lastone.end, cur.end);
		} else {
			target.add(cur);
		}

	}


}

private class StartComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval i1, Interval i2){
		return i1.start - i2.start;
	}
}


private class EndComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval i1, Interval i2){
		return i1.end - i2.end;
	}
}