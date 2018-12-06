
```
class Solution {
    public int trapRainWater(int[][] heightMap) {
    	
        if(heightMap == null || heightMap.length < 2 || heightMap[0].length < 2){
        	return 0;
        }

        int n = heightMap.length;
        int m = heightMap[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>(new TupleComparator());

        boolean[][] visited = new boolean[n][m];

        int height = 0;

        int result = 0;

        // init

        init(pq, visited, heightMap, n, m);



        while(!pq.isEmpty()){

        	Tuple cur = pq.poll();


        	if(cur.val > height){
        		height = cur.val;
        	} else {
        		result += height - cur.val;
        	}

        	for(int[] d : directions){
        		int x = cur.x + d[0];
        		int y = cur.y + d[1];

        		if(!isValid(x, y, heightMap) || visited[x][y]){
        			continue;
        		}

        		pq.offer(new Tuple(x, y, heightMap[x][y]));
        		visited[x][y];
        	}
        }


        return result;
    }


    private class Tuple{

    	int x;
    	int y;
    	int val;

    	public Tuple(int _x, int _y, int _val){
    		x = _x;
    		y = _y;
    		val = _val;
    	}
    }

    private class TupleComparator implements Comparator<Tuple>{

    	@Override
    	public int compare(Tuple t1, Tuple t2){
    		return t1.val - t2.val;
    	}

    }

    private boolean isValid(int x, int y, int[][] heightMap){
    	if(x < 0 || y < 0 || x >= heightMap.length || y >= heightMap[0].length){
    		return false;
    	}
    	return true;
    }


    private final int[][] dircetions 

    = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    private void init(PriorityQueue<Tuple> pq, boolean[][] visited, int[][] heightMa, int n, int m){
    	for(int i = 0; i < heightMap.length; i ++){
        	pq.offer(new Tuple(i, 0, heightMap[i][0]));
        	pq.offer(new Tuple(i, m-1, heightMap[i][m]));
        	visited[i][0] = true;
        	visited[i][m-1] = true;
        }

        for(int j = 0; j < heightMap[0].length; j ++){
        	pq.offer(new Tuple(0, j, heightMap[0][j]));
        	pq.offer(new Tuple(n-1, j, heightMap[n-1][j]));
        	visited[0][j] = true;
        	visited[n-1][j] = true;
        }
    }
}

