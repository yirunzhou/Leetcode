
```
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


	Given a collection of intervals, merge all overlapping intervals.

	Example 1:

	Input: [[1,3],[2,6],[8,10],[15,18]]
	Output: [[1,6],[8,10],[15,18]]
	Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	Example 2:

	Input: [[1,4],[4,5]]
	Output: [[1,5]]
	Explanation: Intervals [1,4] and [4,5] are considerred overlapping.


								i
	[[1,3],[2,6],[8,10],[15,18]]

	init

	start = 1
	end = 3

	for each interval

	if i.start <= end

		merge:
			end = Math.max(end, i.end)

		i ++

	else 
		create new interval(start, end)
		reset start, end



	add remain start,end to result	



class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if(intervals == null || intervals.size() == 0){
        	return result;
        }

        Collections.sort(intervals, new IntervalComparator());

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;


        for(int i = 1; i < intervals.size(); i ++){

        	Interval cur = intervals.get(i);

        	if(cur.start <= end){
        		//merge
        		end = Math.max(end, cur.end);
        	} else {
        		// create new 
        		result.add(new Interval(start, end));
        		start = cur.start;
        		end = cur.end;
        	}

        }

        result.add(new Interval(start, end));

        return result;
    }

   	private class IntervalComparator implements Comparator<Interval>{
		@Override
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }
   	}

}