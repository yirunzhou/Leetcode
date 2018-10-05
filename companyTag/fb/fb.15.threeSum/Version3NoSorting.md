```
public List<List<Integer>> threeSum(int[] nums) {
    
    List<List<Integer>> res = new ArrayList<>();

    if(nums == null || nums.length < 3){
    	return res;
    }


    // # - occ

	Map<Integer, Integer> map = new HashMap<>();

	for(int num : nums){
		map.put(num, map.getOrDefault(num, 0) + 1);
	}


	// choose the first #
	for(int i : map.keySet()){

		int iOcc = map.get(i);

		map.put(i, iOcc - 1);


		// choose a second #
		for(int j : map.keySet()){
			

			int jOcc = map.get(j);


			if(i > j || jOcc == 0){
				continue;
			}


			map.put(j, jOcc - 1);


			// see if the third exists

			int target = - i - j;
			if(target < j){
				continue;
			}


			if(map.containsKey(target) && map.get(target) > 0){
				List<Integer> newRes = new ArrayList<>(Arrays.asList(i, j, target));
				if(noDup(res, newRes)){
					res.add(newRes);
				}
			}

			// recover j
			map.put(j, jOcc);
		}

		// recover i
		map.put(i, iOcc);
	}

	return res;
}


private boolean noDup(List<List<Integer>> res, List<Integer> newRes){
	int counter = 0;

	for(List<Integer> list : res){
		for(int i = 0; i < 3; i ++){
			if(list.get(i) == res.get(i)){
				counter ++;
			}
		}
	}

	return counter != 3;

}