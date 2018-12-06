

/**
	Sol 1

		1. valid tree -> edges + 1 = vertices

			thus filter the edges + 1 != vertices

		2. edges + 1 == vertices, may have circle + disjoint

			thus detect circle 

			using union find

	Sol 2
		
		1. no check with edges

		2. detect circle

		3. cnt for root
*/





class Solution {
    public boolean validTree(int n, int[][] edges) {
        // detect a undirected graph's circle
        
        // union find
        
        UF uf = new UF(n);
        
        for(int[] e : edges){
            if(!uf.union(e[0], e[1])){
                return false;
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i ++){
            if(i == uf.find(i)){
                cnt ++;
            }
        }
        
        return cnt == 1;
    }
    
    private class UF{
        private Map<Integer, Integer> map = new HashMap<>();
        public UF(int n){
            for(int i = 0; i < n; i ++){
                map.put(i, i);
            }
        }
        
        // return false when i, j already connected -> circle
        public boolean union(int i, int j){
            int ir = find(i);
            int jr = find(j);
            
            if(ir == jr){return false;}
            
            map.put(ir, jr);
            return true;
        }
        
        public int find(int i){
            while(i != map.get(i)){
                map.put(map.get(i), map.get(map.get(i)));
                i = map.get(i);
            }
            return i;
        }
    }
}