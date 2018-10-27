

```

	1	1	1	1	3	5	5
	one
							3nd

	1st | -> loop
	2nd	| -> set
	3rd	| -> loop

	acending


	1. choose 1st 

	2. find unique two sum in the rest -> 2nd

		2.1 see that if there is a match

			2.1.1 if it is, we have




public List<List<Integer>> threeSum(int[] candidates){

	List<List<Integer>> result = new ArrayList<>();

	Arrays.sort(candidates);

	for(int i = 0; i < candidates.length; i ++){
		if(i != 0 && candidates[i] == candidates[i-1]){
			continue;
		}

		Set<Integer> set = new HashSet<>();

		for(int j = i + 1; j < candidates.length; j ++){

			int toFind = 0 - candidates[i] - candidates[j];

			if(set.contains(toFind)){
				result.add(new ArrayList<Integer>(Arrays.asList(
					candidates[i], toFind, candidates[j])));


				while(j+1 < candidates.length && candidates[j] == candidates[j+1]){
					j ++;
				}


				/* 
					CASE1 :

					1	1	1	1	1	2
					i		j		j'

					->	point to j', add or not add are fine


					CASE2 :

					1	1	2	2	2
					i		j		j'

					-> point to j', add

					if 1 1 2 is ans

					then 1 2 2 is not


					Thus
						1. point to the last one of dup
						2. add

				*/
			} 

			set.add(candidates[j]);

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
		

		int lo = i + 1;
		int hi = candidates.length-1;

		while(lo < hi){

			int sum = nums[i] + nums[lo] + nums[hi];

			if(sum == 0){

				result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lo], nums[hi])));

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

		return result;

	}


}


/*

		1	1	2	2	2	3	4

		i
							j

		1+2+2

	set: 1	2
*/


public List<List<Integer>> threeSum(int[] candidates){

	List<List<Integer>> result = new ArrayList<>();

	Arrays.sort(candidates);

	for(int i = 0; i < candidates.length; i ++){

		if(i != 0 && candidates[i] == candidates[i-1]){
			continue;
		}

		Set<Integer> set = new HashSet<>();

		for(int j = i + 1; j < candidates.length; j ++){

			int target = 0 - nums[i] - nums[j];

			if(set.contains(target)){

				result.add(new ArrayList<Integer>(Arrays.asList(
					nums[i], taregt, nums[j])));

				set.add(nums[j]);

				while(j < candidates.length && candidates[j] == candidates[j+1]){
					j ++;
				}

				j ++;

			} else {
				set.add(nums[j]);
			}
			
		}
	}

	return result;

}






