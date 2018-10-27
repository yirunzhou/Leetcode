

```

	[6, 8]
	[8, 10]
	[9,10]
	[12, 14]

	6	t	
	8	f
	8	t
	9	t
	10	f
	10	f
	12	t
	14	f


									i

	6	8	8	9	10	10	12	14
	t	f	t	t	f	f	t	f


var:

	price: 14

	counter: 0

	profit:	14

	unacc: 0


	max: 20


	put critical point into a list

	sort the list 

	iterate

		0. set price
		1. if acc -> counter ++
		2. if una -> unacc ++

		3. end of the same price
			counter -= uacc

		4. get profit, update max


	






public int maxProfit(Interval[] intervals) {


	int max = 0;

	List<Pair> pairs = new ArrayList<>();

	for(Interval i : intervals)
		pairs.add(new Pair(i.start, true));
		pairs.add(new Pair(i.end, false));
	}


	Colletions.sort(pairs, new PairComparator());


	int counter = 0;

	for(int i = 0; i < pairs.size(); i ++){

		Pair cur = pairs.get(i);

		int price = cur.price;

		int unacc = 0;

		if(cur.acc){
			counter ++;
		} else {
			uacc --;
		}

		while(i+1 < pairs.size() && pairs.get(i+1).price == price){
			i ++;

			if(pairs.get(i).acc){
				counter ++;
			} else {
				uacc ++;
			}
		}

		int profit = counter * price;

		max = Math.max(max, profit);


		counter -= uacc;
	}

	return max;
}



private class Pair{

	public int price;

	public boolean acc;
}