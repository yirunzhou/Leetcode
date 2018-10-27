validPalindrome.md

Control flow:
	
	if not valid char, pointer move, and **continue**

	if no continue, will judge the eqauvalence, resulting unintentional comparison

API name: 

	Character.isLetterOrDigit()
	Character.toLowerCase()


```
	class Solution {
    public boolean isPalindrome(String s) {
        
        if(s.length() == 0){
            return true;
        }
        
        int lo = 0;
        int hi = s.length()-1;
        
        while(lo < hi){
            
            if(!Character.isLetterOrDigit(s.charAt(lo))){
                lo ++;
                continue;
            }
            
            if(!Character.isLetterOrDigit(s.charAt(hi))){
                hi --;
                continue;
            }
            
            if(Character.toLowerCase(s.charAt(hi)) != Character.toLowerCase(s.charAt(lo))){
                return false;
            }
            
            lo ++;
            hi --;
            
        }
        
        return true;
    }
}

```