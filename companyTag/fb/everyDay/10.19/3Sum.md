
```


public List<List<Integer>> threeSum(int[] candidates){

	Arrays.sort(candidates);

	List<List<Integer>> result = new ArrayList<>();

	for(int i = 0; i < candidates.length; i ++){

		if(i != 0 && candidates[i] == candidates[i-1]){
			i ++;
		}

		int lo = i + 1;
		int hi = candidates.length-1;

		while(lo < hi){

			int sum = candidates[i] + candidates[lo] + candidates[hi];

			if(sum == 0){

				result.add(new ArrayList<Integer>(Arrays.asList(

					candidates[i], candidates[lo], candidates[hi]

				)));

				while(lo < hi && candidates[lo] == candidates[lo+1]){
					lo ++;
				}

				while(lo < hi && candidates[hi] == candidates[hi-1]){
					hi --;
				}

				lo ++;
				hi --;

			} else if(sum > 0){

				hi --;

			} else {

				lo ++;

			}

		}

	}

	return result;
}



public List<List<Integer>> threeSum(int[] candidates){

	Arrays.sort(candidates);

	List<List<Integer>> result = new ArrayList<>();

	for(int i = 0; i < candidates.length; i ++){

		if(i != 0 && candidates[i] == candidates[i-1]){
			continue;
		}

		Set<Integer> set = new HashSet<>();

		for(int j = i + 1; j < candidates.length; j ++){

			int toFind = 0 - candidates[i] - candidates[j];

			if(set.contains(toFind)){

				result.add(new ArrayList<Integer>(Arrays.asList(
					candidates[i], toFind, candidates[j]
				)));

				//  1	1	1	1	1	2	2	2	3
				//	i							j

				while(j+1 < candidates.length() && candidates[j] == candidates[j+1]){
					j ++;
				}
			}

			set.add(candidates[j]);

		}

	}

	return result;
}
























public List<List<Integer>> threeSum(int[] candidates){

	List<List<Integer>> result = new ArrayList<>();

	Arrays.sort(candidates);

	for(int i = 0; i < candidates.length; i ++){

		if(i != 0 && candidates[i-1] == candidates[i]){
			continue;
		}

		Set<Integer> seen = new HashSet<>();

		for(int j = i + 1; j < candidates.length; j ++){

			int target = 0 - candidates[i] - candidates[j];

			if(seen.contains(target)){

				result.add(new ArrayList<Integer>(Arrays.asList(

					candidates[i], target, candidates[j]

				)));

				// move j to the last of the duplication

				while(j+1 < candidates.length && candidates[j] == candidates[j+1]){
					j ++;
				}
			}

			set.add(candidates[j]);

		}

	}

	//	1	1	1	1	2	2	3	
		i	
						j

	return result;
}




