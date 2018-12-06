/**
        
    Union find:
    
        find():
            int[] parent is just parent node, not root
        
        union():
            quick union, connect two nodes together
*/


private int find(int[] parent, int i){
    while(parent[i] != i){
        // point it to its grand
        parent[i] = parent[parent[i]];
        i = parent[i];
    }
    return i;
}



/**
    Redundant:
        
        1. link to root --> circle, no double parent
        2. link to non-root --> circle with double parent


    Do DAG:

    1.  
        return the edge makes circle    

    2.

        Then try to find the double parent node

        Remove the latter edge

            if still circle -> return another

            no circle then return the latter edge

*/


class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        
        int[] parent = new int[edges.length+1];
        int[] edgeA = new int[2];
        int[] edgeB = new int[2];
        boolean doubleParent = false;
        
        for(int[] e : edges){
            
            int start = e[0];
            int end = e[1];
            
            if(parent[end] != 0){
                doubleParent = true;
                edgeA = new int[]{parent[end], end};
                edgeB = new int[]{start, end};
                // disable edgeB
                e[1] = 0;
                break;
            }
            
            parent[end] = start;
        }
        
        // clear
        for(int i = 0; i < parent.length; i ++){
            parent[i] = i;
        }
        
        
        // case 1 : double edge -> if no circle then return B, else return A
        // case 2 : circle -> circle then return current edge
        for(int[] e : edges){
            
            if(e[1] == 0){
                continue;
            }
            
            int first = e[0];
            int second = e[1];
            
            // circle
            if(find(parent, first) == second){
                if(doubleParent){
                    return edgeA;
                } else return e;
            }
                
            parent[second] = first;
        }
        
        return edgeB;
    }
    
    private int find(int[] parent, int i){
        while(parent[i] != i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}