
/**
	UF solution

	what we need is a uf to decide whether two vertices are connected,
	their distance to root
	
	
	two map : parent, ratio
	
	1. union

		r1 = find(s1)
		r2 = find(s2)
		
		change the parent(r1), ratio(r1)

	
	2. find with path compression(compress current node's parent to its root)

		need to know:
			 s/f
			 f/r
			
		s/f -> ratio(s)
		f/r -> after path compress f, ratio(f)
		
		thus need to recursively call find(f)
		


		2.1 
			f = parent.get(s)
			r = find(f)

		2.2 ratio.put(s, ratio(s) * ratio(f))

		2.3	return r


		Thus we end with all the path between s ->...->r are compressed
		

*/



class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        /**
            loop eq
                put into union find set
                    uf : parent, x / parent
                    init with itself, 1.0
                union
            
            n equations
            m queries
            
            -> amotized O(n) + O(m)
            
        */
        
        UF uf = new UF();
        
        double[] result = new double[queries.length];
        
        for(int i = 0; i < equations.length; i ++){
            String[] e = equations[i];
            uf.union(e[0], e[1], values[i]);
        }
        
        for(int i = 0; i < queries.length; i ++){
            
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            
            if(uf.find(s1) == null || uf.find(s2) == null || !uf.find(s1).equals(uf.find(s2))){
                result[i] = -1.0;
            } else {
                result[i] = uf.ratio.get(s1) / uf.ratio.get(s2);
            }
            
        }
        
        return result;
        
    }
    
    private class UF{
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> ratio = new HashMap<>();
        
        public void union(String s1, String s2, double val){
            if(!parent.containsKey(s1)){
                parent.put(s1, s1);
                ratio.put(s1, 1.0);
            }
            if(!parent.containsKey(s2)){
                parent.put(s2, s2);
                ratio.put(s2, 1.0);
            }
            
            // origin root
            String r1 = find(s1);
            String r2 = find(s2);
            
            parent.put(r2, r1);
            ratio.put(r2, ratio.get(s1) / ratio.get(s2) / val);
            // compress
            find(s1);
            find(s2);
        }
        
        public String find(String s){
            if(!parent.containsKey(s)){
                return null;
            }
            if(s.equals(parent.get(s))){
               return s; 
            }
            
            String father = parent.get(s);
            String root = find(father);
            /**
                s -> father -> ..... -> root
            
                s -> father -> root
                    
                    f/r
                    s/f
                    s/r = s/f * f/r
            */
            parent.put(s, root);
            ratio.put(s, ratio.get(s) * ratio.get(father));
            return root;
        }
    }
}