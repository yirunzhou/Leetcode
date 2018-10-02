
public class Solution{
	
	public int subarraySumEqualsK(int[] nums, int k){
		if(nums == null){
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int counter = 0;
		int sum = 0;

		for(int i = 0; i < nums.length; i ++){
			sum += nums[i];
			if(map.containsKey(sum-k)){
				counter += map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return counter;
	}
}