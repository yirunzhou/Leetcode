


```

public int minMeetingRooms(Interval[] intervals) {
        
        List<Pair> pairs = new ArrayList<>();
        
        for(Interval i : intervals){
            
            pairs.add(new Pair(i.start, true));
            pairs.add(new Pair(i.end, false));
            
        }
        
        Collections.sort(pairs, new PairComparator());
        
        int maxProfit = 0;
        
        int price = 0;
        
        int counter = 0;
        
        int profit = 0;
        
        
        for(int i = 0; i < pairs.size(); i ++){
            
            int unacc = 0;

            price = pairs.get(i).price;
            
            if(pairs.get(i).acc){
            	counter ++;
            } else {
            	uacc ++;
            }


            while(i+1 < pairs.size() && pairs.get(i).price == pairs.get(i+1).price){

            	i ++;

            	if(pairs.get(i).acc){
            		counter ++;
            	} else {
            		uacc ++;
            	}

            }

            profit = counter * price;

            maxProfit = Math.max(maxProfit, profit);

            counter -= uacc;

        }
        
        return maxProfit;
        
    }
    
    private class PairComparator implements Comparator<Pair>{
        
        @Override
        public int compare(Pair p1, Pair p2){
            
            if(p1.time == p2.time){
                
                if(p1.isStart == p2.isStart){
                    return 0;
                }
                
                if(!p1.isStart){
                    return -1;
                }
                
                else {
                    return 1;
                }
            } 
            
            return p1.time - p2.time;
            
        }
        
        // [12, f] [12, t]
    }
    
    private class Pair{
        
        public boolean acc;
        public int price;
        
        public Pair(int price, boolean acc){
            this.acc = acc;
            this.price = price;
        }
    }