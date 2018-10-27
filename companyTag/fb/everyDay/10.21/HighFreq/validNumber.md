validNumber


When dealing with input, try to do 

```
	if(){}
	else if(){}
	else if(){}
	else {}
```

so that the block is clear, I can deal with different category separetely, without intersection

```

class Solution {
    public boolean isNumber(String s) {
        // 1. empty? leading, tailling spaces? mid spaces?
        /**
             65. Valid Number  没有科学计数法e，加号 和 空格 以及其他字符都算错。
             
             2. invalid input
             3. dup sign, or not first char sign
             4. dup dot
             5. no number before and after dot
             6. no number when no dot
        
        */ 
        
        boolean seenSign = false;
        boolean seenDot = false;
        boolean seenNumberBeforeDot = false;
        boolean seenNumberAfterDot = false;
        
        s = s.trim();
        
        for(int i = 0;i < s.length(); i ++){
            
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(seenSign || i != 0){
                    return false;
                }
                seenSign = true;
                
            }
            
            else if(s.charAt(i) == '.'){
                if(seenDot){
                    return false;
                }
                seenDot = true;
            }
            
            else if(Character.isDigit(s.charAt(i))){
                if(!seenDot){
                    seenNumberBeforeDot = true;
                } else {
                    seenNumberAfterDot = true;
                }
            }
            
            else {
                return false;
            }
            
        }
        
        
        
        if(seenDot){
            // +. or .
            if(!seenNumberBeforeDot && !seenNumberAfterDot){
                return false;
            }
        } else {
            // only sign, or empty
            if(!seenNumberBeforeDot){
                return false;
            }
        }
        
        return true;
    }
}
```