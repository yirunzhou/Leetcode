**Array Question Corner Case : EMPTY ARRAY or EMPTY SUBARRAY**


```
public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
    	int len = 0;

    	for(int[] array : arrays){
    		len += array.length;
    	}
        
    	int[] result = new int[len];
    	int ptrm = len-1;

    	PriorityQueue<Tuple> pq = new PriorityQueue<>(new TupleComparator());

    	for(int i = 0; i < arrays.length; i ++){
    		int x = i;
    		int y = arrays[i].length -1;
    		if(y < 0){
    			continue;
    		}
    		pq.offer(new Tuple(
    				arrays[x][y],
    				x,
    				y
    		));
    	}

    	while(!pq.isEmpty()){
    		Tuple cur = pq.poll();

    		result[ptrm --] = cur.val;

    		if(cur.ptr != 0){
    			pq.offer(
    				new Tuple(
    				arrays[cur.i][cur.ptr-1], 
    				cur.i, 
    				cur.ptr-1
    				)
    			);
    		}
    	}

    	return result;
    }

    private class Tuple{
    	int val;
    	int i;
    	int ptr;
    	public Tuple(int _val, int _i, int _ptr){
    		val = _val;
    		i = _i;
    		ptr = _ptr;
    	}
    }

    private class TupleComparator implements Comparator<Tuple>{
    	@Override
    	public int compare(Tuple t1, Tuple t2){
    		if(t1.val < t2.val){
    			return 1;
    		} else if(t1.val == t2.val){
    			return 0;
    		} else {
    			return -1;
    		}
    	}
    }
}