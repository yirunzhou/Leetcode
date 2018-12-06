

/**
	0. init graph, indegree of every char, as we want to know the topo sequence of all the chars
		
		Once we found the c1->c2 pair, we should break, the afterwards char pairs will be misleading
	
	1. topo sort
*/



class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        
        // iterate over the words, init all chars
        for(String word : words){
            for(char c : word.toCharArray()){
                if(!indegree.containsKey(c)) indegree.put(c, 0);
                if(!graph.containsKey(c)) graph.put(c, new HashSet<Character>());
            }
        }
        
        for(int i = 0; i < words.length-1; i ++){
            
            // find out the first diff char pair
            String word1 = words[i];
            String word2 = words[i+1];
            
            // if no, then continue
            // else we build c1 -> c2 edge
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j ++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    // if the children set has no c2 yet, update indegree
                    if(graph.get(c1).add(c2)){
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
                
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        for(Map.Entry<Character, Integer> e : indegree.entrySet()){
            if(e.getValue() == 0){
                queue.offer(e.getKey());
            }
        }
        
        while(!queue.isEmpty()){
            
            Character cur = queue.poll();
            result.append(cur);
            
            for(Character child : graph.get(cur)){
                int prev = indegree.get(child);
                if(prev == 1){
                    queue.offer(child);
                }
                indegree.put(child, prev-1);
            }
        }
        
        if(result.length() != graph.size()){
            return "";
        }
        
        return result.toString();
    }
}