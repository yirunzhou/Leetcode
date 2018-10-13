**String problem, MUST CLARITFY!**
	
	1.input range 
	2.consider numeric? apha? (? , ! .)
	3.lower? upper?

**APIS**

	Character.isLetter()
	Character.isDigit()
	Character.isLetterOrDigit()

	Character.toLowerCase()



```


public boolean isPalindorme(String input){

	if(input == null || input.length() == 0){
		return true;
	}

	int lo = 0;
	int hi = input.length()-1;

	while(lo < hi){

		if(!Character.isLetterOrDigit(input.charAt(lo))){
			lo ++;
			continue;
		}

		if(!Character.isLetterOrDigit(input.charAt(hi))){
			hi --;
			continue;
		}

		if(Character.toLoweCase(input.charAt(lo)) != 
			Character.toLowerCase(input.charAt(hi)))
			{
				return false;
			}

		lo ++;
		hi --;
	}	

	return true;

}