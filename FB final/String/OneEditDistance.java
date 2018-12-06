

	Meaning of the comparison loop is that we compare the common length

	If we ending up with all common length chars same, 

	then we should compare if they are exactly the same,

	or if their length diff is more than 1




Mistakes:

	1. Inserting -> substring a longer one with i+1

	2. check the length diff outside the loop





```
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        for(int i = 0; i < Math.min(s.length(), t.length()); i ++){
            
            if(s.charAt(i) == t.charAt(i)){
                continue;
            }
            
            if(s.length() > t.length()){
                
                return s.substring(i+1).equals(t.substring(i));
                
            } else if(s.length() < t.length()){
                
                return s.substring(i).equals(t.substring(i+1));
                
            } else {
                
                return s.substring(i+1).equals(t.substring(i+1));
            }
            
        }
        
        
        return Math.abs(s.length() - t.length()) == 1;
        
    }
}