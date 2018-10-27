
```
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
    	List<List<Integer>> result = new ArrayList<>();

    	Arrays.sort(nums);

    	Map<Integer, List<Pair>> map = new HashMap<>();


    	for(int i = 0; i < nums.length; i ++){

    		if(i != 0 && nums[i] == nums[i-1]){
    			continue;
    		}

    		for(int j = i + 1; j < nums.length; j ++){

    			if(j != i + 1 && nums[j] == nums[j-1]){
    				continue;
    			}

    			int sum = nums[i] + nums[j];

    			Pair newp = new Pair(i, j);

    			int toFind = target - sum;

    			if(map.containsKey(toFind)){
    				for(Pair p : map.get(toFind)){
    					if(!isCommon(p, newp)){
    						addToResult(result, p, newp, nums);
    					}
    				}
    			}

    			if(!map.containsKey(sum)){
    				map.put(sum, new ArrayList<Pair>());
    			}

    			map.get(sum).add(newp);
    		}
    	}

    	return result;
    }

    private void addToResult(List<List<Integer>> result, Pair p1, Pair p2, int[] nums){
    	List<Integer> list = new ArrayList<>();
		list.add(nums[p.x]);
		list.add(nums[p.y]);
		list.add(nums[newp.x]);
		list.add(nums[newp.y]);
		result.add(list);
    }

    private boolean isCommon(Pair p1, Pair p2){

    	if(p1.x == p2.x || p1.x == p2.y){
    		return true;
    	}

    	if(p1.y == p2.x || p1.y == p2.y){
    		return true;
    	}

    	return false;
    }


    private class Pair{
    	int x;
    	int y;

    	public Pair(int _x, int _y){
    		x = _x;
    		y = _y;
    	}
    }
}