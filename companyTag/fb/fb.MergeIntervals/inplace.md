```

[[1,3],[2,6],[8,10],[15,18]]

								j
				i
[[1,6],[8,10],[15,18],[15,18]]
	


j	overlap with i?
	no -> i++ inter[i] = inter[j]

	yes -> merge, j ++



[0, i], merged intervals

[j, len-1] explor, if overlap with i, merge, if no, then move i, inter[i] = inter[j], move j


start = 1
end = 6


public List<Interval> merge(List<Interval> intervals) {

	Collections.sort(intervals, new IntervalComparator());

	int i = 0;
	int j = 1;

	while(j < intervals.size()){

		if(overlap(intervals.get(i), intervals.get(j))){

			intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(j).end);

			j ++;

		} else {

			i ++;

			intervals.set(i, intervals.get(j));

			j ++;
		}
	}

	System.out.print(i+1);

	return intervals;

}


