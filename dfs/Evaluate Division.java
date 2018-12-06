/**
    
    construct a undirect graph

    find two vertices' path

    
    always to avoid dup iterate when traversing graph

    Matrix:

        1. visited boolean
        2. change value of the matrix, backtrack

        When determine the shortest distance : 
            distance matrix, keep track of current path distance to reach that point, if even larger, no further

    Non-Matrix:

        1. set of vertices visited
        2. remove the vertice when visiting, backtrack
    
    

*/


class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<Double>> weight = new HashMap<>();
        
        for(int i = 0 ; i < equations.length; i ++){
            
            String[] e = equations[i];
            
            if(!graph.containsKey(e[0])){
                graph.put(e[0], new ArrayList<String>());
                weight.put(e[0], new ArrayList<Double>());
            }
            
            if(!graph.containsKey(e[1])){
                graph.put(e[1], new ArrayList<String>());
                weight.put(e[1], new ArrayList<Double>());   
            }
            
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            weight.get(e[0]).add(values[i]);
            weight.get(e[1]).add((double)1/values[i]);
        }
        
        double[] result = new double[queries.length];
        
        for(int i = 0; i < queries.length; i ++){
            // graph, w, start, end, 
            // return the value from start -> end, find the path and accu the path value
            String[] query = queries[i];
            
            double[] res = {1.0};
            
            boolean found = dfs(graph, weight, query[0], query[1], new HashSet<String>(), res);
            
            if(!found){
                result[i] = -1.0;
            } else {
                result[i] = res[0]; 
            }
        }
        
        return result;
    }


    // path means before start, we have iterate through how many nodes, 
    // res is the value that original start -> currennt start
    private boolean dfs(Map<String, List<String>> graph, Map<String, List<Double>> weight, String start, String end, 
                       Set<String> path, double[] res){
        /**
            a   b   c   d
            b   e   f
            e   g   h
            
            start = a 
            end = h
            
            a   b   e   h
            
            1. if start is end -> return 
            2. if circle -> return fals
            
            3. loop through the child, to see if true, then this child is connected to the end, return the acc * res[0]
            
            4. return false
        */
        if(!graph.containsKey(start)) return false;
        
        if(path.contains(start)) return false;
        if(start.equals(end)) return true;
        path.add(start);
        
        List<String> children = graph.get(start);
        List<Double> curWeight = weight.get(start);
        
        for(int i = 0; i < children.size(); i ++){
            double ori = res[0];
            res[0] *= curWeight.get(i);
            boolean found = dfs(graph, weight, children.get(i), end, path, res);
            if(found){
                return true;
            }
            res[0] = ori;
        }
        
        return false;
    }
}