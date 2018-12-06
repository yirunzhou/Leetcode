



Mistakes:

	1. Scan line solution:

			comparator:
```
				if (p1.time == p2.time){

					if(p1.isStart == p2.isStart){
						return 0;
					} else if(p1.start == false){
						return -1;
					} else{
						return 1;
					}

				} else {
					...
				}
```
			Comparator is for Pairs, not for Intervals
			Sort or not sort of the original interval does not really matter

	2. PQ solution:

			Arrays.sort(Interval[]), not Collections

			inside the add to pq loop, the logic could be simplfied to

```
		for(Interval cur : intervals){

			while(!pq.isEmpty() && pq.peek() <= cur.start){
				pq.poll();
			}

			pq.offer(cur);

			Math.max(max, pq.size());
		}
```





```
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            
            return 0;
        
        }
        
        List<Pair> list = new ArrayList<>();
        
    
        for(Interval interval : intervals){
        
            list.add(new Pair(interval.start, true));
            list.add(new Pair(interval.end, false));
        
        }
        
        Collections.sort(list, new PairComparator());
        
        
        int counter = 0;
        int max = 0;
        
        
        for(Pair cur : list){
        
            if(cur.isStart){
                
                counter ++;
                max = Math.max(max, counter);
            
            } else{
             
                counter --;
                
            }
        
        }
        
        return max;
    }
    
    
    private class Pair{
        public int time;
        public boolean isStart;
        
        public Pair(int t, boolean isS){
        
            time = t;
            isStart = isS;
        }
           
    }
    
    private class PairComparator implements Comparator<Pair>{
        
        @Override
        public int compare(Pair p1, Pair p2){
            
            if(p1.time == p2.time){
                
                // false to be put in front
                
                if(p1.isStart == p2.isStart){
                    return 0;
                }
                
                if(p1.isStart == false){
                    return -1;
                } else {
                    return 1;
                }
                
            } else {
             
                if(p1.time < p2.time){
                    return -1;
                } else {
                    return 1;   
                }
                
            }
        
        }
        
    }
    
}


```


```

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        
        if(intervals == null){
            return 0;
        }
        
        Arrays.sort(intervals, new StartComparator());
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(new EndComparator());
        
        
        int max = 0;
        
        
        // pq is the meeting ungoing
        
        
        for(Interval cur : intervals){
        
            while(!pq.isEmpty() && pq.peek().end <= cur.start){
                pq.poll();
            }

            pq.offer(cur);
            
            max= Math.max(max, pq.size());
            
        }
        
        return max;
    }
    
    private class StartComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            
            if(i1.start == i2.start){
                return 0;
            } else if(i1.start < i2.start){
                return -1;
            } else {
                return 1;
            }
        
        }
    }
    
    private class EndComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            
            if(i1.end == i2.end){
                return 0;
            } else if(i1.end < i2.end){
                return -1;
            } else {
                return 1;
            }
        
        }
        
    }
    
}

