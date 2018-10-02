
* CATCH: result may be 0, 1, 2, 3, so not /=2, is -=2

```
	public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0){
            int na = i >= 0 ? a.charAt(i) - '0' : 0;
            int nb = j >= 0 ? b.charAt(j) - '0' : 0;
            int result = na + nb + carry;
            carry = result / 2;
            if(result > 1){
                result -= 2; 
            }
            sb.append(result);
            i --;
            j --;
        }
        
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
```