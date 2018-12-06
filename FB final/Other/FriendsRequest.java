

Mistakes:

	x / 2 equations should not *2, considering the truncate of integers

	be clear about the meaning of variable

	requestPerPerson or total?




```

class Solution {
    public int numFriendRequests(int[] ages) {
        
        int[] buckets = new int[121];
        
        for(int age : ages){
            buckets[age] ++;
        }
        
        int total = 0;
        
        for(int i = 15; i <= 120; i ++){
            
            int curAge = i;
            
            if(buckets[curAge] == 0){
                continue;
            }
            
            int curRequest = 0;
            
            for(int k = i/2 + 8; k <= i; k ++){
                
                curRequest += buckets[k];
                
            }
            
            // will not send himself request
            curRequest -= 1;
            
                        
            total += curRequest * buckets[curAge];
        }
        
        return total;   
    }
}