minimumWindowSubstring.md

Clarify:

	the input is all in ASCII?

	



```

class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[256];
        
        for(char c : t.toCharArray()){
            freq[(int)c] ++;
        }
        
        int counter = t.length();
        
        int lo = 0;
        int hi = 0;
        
        int resultLo = 0;
        int resultHi = 0;
        
        int minLen = s.length();
        
        for(; lo < s.length(); lo ++){
            
            while(hi < s.length() && counter > 0){
                char add = s.charAt(hi);
                
                if(freq[(int)add] >= 1){
                    counter --;
                }
                
                freq[(int)add]--;
                
                hi ++;
            }
            
            if(counter == 0){
                
                if(minLen >= hi - lo){
                    minLen = hi - lo;
                    resultLo = lo;
                    resultHi = hi;
                }
                
            }
            
            // remove lo from map
            char delete = s.charAt(lo);
            
            if(freq[(int)delete] >= 0){
                counter ++;
            }
            
            freq[(int)delete] ++;
        }
        
        return s.substring(resultLo, resultHi);
    }
}

```