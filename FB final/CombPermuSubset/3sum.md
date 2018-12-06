


Mistakes:

	
	Hash two sum solution:

		1.Dedup when find a result

```
	while(j < nums.length && nums[j] == nums[j+1])
```
		is not enough, as j+1 may out of bound, it is different from two pointer dedup


		2.Meaning of the set is candidates we can pick to match to target, then we should iterate though all the numbers to put into set, we cannot just find a result and quit, miss the potential result



	Two pointer solution:



	No sorting solution: 

		1. keep the thrid >= second >= first


```

No sorting solution:


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        Set<String> dedupSet = new HashSet<>();
        
        for(int num : nums){
            
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            
        }
        
        for(int first : freq.keySet()){
            
            freq.put(first, freq.get(first) - 1);
            
            
            
            for(int second : freq.keySet()){
                
                if(second < first || freq.get(second) == 0) {
                    continue;
                }
                
                freq.put(second, freq.get(second) -1);
                
                
                
                
                int target = -first - second;
                
                if(target >= second){
                
                
                    if(freq.containsKey(target) && freq.get(target) != 0){

                        List<Integer> subresult = new ArrayList<>(
                            Arrays.asList(first, second, target));

                        if(unique(dedupSet, subresult)){

                            result.add(subresult);

                        }

                    }
                
                }
                
                
                freq.put(second, freq.get(second) + 1);
                
            }
            
            
            
            freq.put(first, freq.get(first) + 1);
            
        }
        
        return result;
        
    }
    
    
    private boolean unique(Set<String> dedupSet, List<Integer> subresult){
        
        StringBuilder encode = new StringBuilder();
        
        for(int elem : subresult){
            encode.append(elem);
            encode.append(" ");
        }
        
        return dedupSet.add(encode.toString());
    }
}

```


