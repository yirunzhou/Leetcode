

public boolean validate(String[] words, String order){

	Map<Character, Integer> orderMap = new HashMap<>();

	for(int i = 0; i < order.length(); i ++){
		orderMap.put(order.charAt(i), i);
	}


	for(int i = 1; i < words.length; i ++){

		String prev = words[i-1];
		String post = words[i];

		int pointer = 0;

		int minLen = Math.min(prev.length(), post.length());

		while(pointer < minLen && prev.charAt(pointer) == post.charAt(pointer)){
			pointer ++;
		}

		if(pointer == minLen){
			if(prev.length() > post.length()){
				return false;
			} else {
				continue;
			}
		}

		char prevCh = prev.charAt(pointer);

		char postCh = post.charAt(pointer);

		Integer prevOcc = orderMap.get(prevCh);

		Integer postOcc = orderMap.get(postCh);

		if(prevOcc == null || postOcc == null){
			continue;
		}

		if(prevOcc > postOcc){
			return false;
		}

	}

	return true;

}