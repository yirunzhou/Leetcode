

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.



Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].




[1,[1, 2]]
2
[1,1]


create a empty result list []

if this is a list -> 
	iterate it 
		-> if its element is a list
			->iterate it



// return the result list
helper function(list)

	if element is a list
		-> iterate it, add all the value into the result list

	else 
		add element into result


```
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

```



```


/**

[
	[1,2,3],

	1,

	[1,[2,3]]

]

	
result [1, 2, 3, 1, 1, 2, 3]


	0:
		call helper -> [1, 2, 3]

		add to result

	1:

		add to result


	2:
		call helper
			result [1, 2, 3]

			0: add to result
			1: helper -> [2,3], add to result

		return [1, 2, 3]

		add to result, 





*/
public class NestedIterator implements Iterator<Integer> {

	private List<Integer> list;

	private int pointer;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = helper(nestedList);
        pointer = 0;
    }

    @Override
    public Integer next() {
    	pointer ++;
        return list.get(pointer-1);
    }

    @Override
    public boolean hasNext() {
        if(pointer >= list.size()){
        	return false;
        }

        return true;
    }


    private List<Integer> helper(List<NestedInteger> nestedList){

    	List<Integer> result = new ArrayList<>();


    	for(NestedInteger ni : nestedList){

    		if(ni.isInteger()){
    			result.add(ni.getInteger());
    		} else {
    			List<Integer> nestedResult = helper(ni.getList());

    			result.addAll(nestedResult);
    		}

    	}


    	return result;
    }
}


