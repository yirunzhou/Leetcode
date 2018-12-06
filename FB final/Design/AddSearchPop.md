



```


class RandomizedCollection {
    
    private Map<Integer, Set<Integer>> locs;
    
    private List<Integer> list;
    
    private Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
        locs = new HashMap<>();
        
        list = new ArrayList<>();
        
        rand = new Random();
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(locs.containsKey(val)){
            
            locs.get(val).add(list.size());
            
            list.add(val);
            
            return false;
            
        } else {
            
            locs.put(val, new LinkedHashSet<Integer>());
            
            locs.get(val).add(list.size());
            
            list.add(val);
            
            return true;
            
        }
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if(!locs.containsKey(val)){
            
            return false;
            
        } else {
            
            if(locs.get(val).isEmpty()){
                return false;
            }
            
            int removeVal = val;
            
            int holeIndex = locs.get(removeVal).iterator().next();
            
            
            int lastone = list.get(list.size()-1);
            
            int moveIndex = list.size()-1;
            
            
            
            // udpate list, set the removeIndex's value to be the lastone, delete last elem
            list.set(holeIndex, lastone);
            
            list.remove(list.size()-1);
            
            
            // update locs' lastone position, and if the element we are deleting is exactly the last one, then dont add
            locs.get(lastone).remove(moveIndex);
            
            locs.get(removeVal).remove(holeIndex);

            
            if(removeIndex != moveIndex){
                locs.get(lastone).add(holeIndex);    
            }
            
        
            return true;
        }
        
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}