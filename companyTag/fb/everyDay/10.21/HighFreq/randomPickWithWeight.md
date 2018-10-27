randomPickWithWeight.md

```
class Solution {

    /**
        
    the upperBound  of  index i is presum[i], when target > presum[i], choose next one    
            
        0   1   2   3   4   
        1   6   2   3   4
        
          t
           mid
        1   7   9   12  16
        
        mid >= t -> mid may be the answer -> make right interval include this value by hi = mid -1
        
        
        
    [1,1]
    [2,7]
    [8,9]
    
    find the smallest one >= rand
    
    */
    private int[] presum;
    
    private Random rand;
    
    private int upperBound;
    
    public Solution(int[] w) {
        
        rand = new Random();
        
        presum = new int[w.length];
        int sum = 0;
        
        for(int i = 0; i < w.length; i ++){
            sum += w[i];
            presum[i] = sum;
        }
        
        upperBound = sum;
        
    }
    
    public int pickIndex() {
        // find the leftmost one that is >= target
        
        // [1, upperBound]
        int target = rand.nextInt(upperBound) +1;
        
        //[0, lo) is < target
        //(hi, len-1] is >= taregt
        // thus we return hi+1
        
        int lo = 0;
        int hi = presum.length-1;
        
        while(lo <= hi){
            
            int mid = lo + (hi - lo) / 2;
            
            if(presum[mid] >= target){
                hi = mid -1;
            } else {
                lo = mid +1;
            }
            
        }
        
        return hi+1;
    }
}

```