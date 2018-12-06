







/**
	O(n^2) to find exists or not

	O(n^3) to find all possible result


=> There are Θ(n4) different quadruplets (nC4, to be exact, so about n4 / 24).
=> There are Θ(n) possible sums (from 1+2+3+4 to (n-3)+(n-2)+(n-1)+n, so about 4n sums).
=> At least one sum must have Ω(n3) different quadruplets.
=> For that sum, we must generate those Ω(n3) quadruplets.
=> For these cases we have to do Ω(n3) work.
=> O(n2 log n) or even O(n2) are impossible.


*/








public boolean fourSum(int[] nums){

	Arrays.sort(nums);

	Map<Integer, List<int[]>> pairs = getPairs(nums);

	for(Map.Entry<Integer, List<int[]>> e : paris.entrySet()){

		int sum1 = e.getKey();

		int sum2 = -sum1;

		if(sum2 < sum1){
			continue;
		}

		List<int[]> sum1Pairs = pairs.get(sum1);

		List<int[]> sum2Pairs = pairs.get(sum2);


		for(int[] candidate_1 : sum1Pairs){

			for(int[] candidate_2 : sum2Pairs){

				if(!hasCommonIndex(candidate_1, candidate_2)){

					return true;

				}

			}
	
		}

	}


	return false;
}




/**
	1	2	2	9	

	[1,2]
	[3,4]

	[1,2,3,4] -> [3,4,1,2]

*/

private Map<Integer, int[]> getPairs(int[] nums){

	Map<Integer, int[]> pairs = new HashMap<>();

	for(int i = 0; i < nums.length; i ++){

		if(i != 0 && nums[i] == nums[i-1]){
			continue;
		}

		for(int j = i + 1; j < nums.length; j ++){

			if(j != i+1 && nums[j] == nums[j-1]){
				continue;
			}

			if(!pairs.containsKey(nums[i] + nums[j])){
				pairs.put(nums[i] + nums[j], new ArrayList<int[]>());
			}

			List<int[]> list = pairs.get(nums[i] + nums[j]);

			list.add(new int[]{i, j});

		}

	}

	return pairs;
}