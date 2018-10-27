```



getFriends(Person p){

}


getMutualFriends(Person p1, Person p2){
	
	// put one friends into set

	// scan another, if exisits in set, then place it into the result

}


List<Person> suggestFriends(Person p){

	List<Person> friendsOfP = getFriends(p);

	Set<Person> firstFriends = new HashSet<>(friendsOfP);

	Map<Person, Integer> secondFriendsMutual = new HashMap<>();



	int maxBound = 0;

	// construct the secondFriend -> mutual friends # with p
	for(Person friendOfP : friendsOfP){

		// get this firend's friendsList

		List<Person> friendOfPsFriends = getFriends(friendOfP);

		for(Person secondFriend : friendOfPsFriends){

			// if this secondfriend is himself or his friend already, skip
			if(secondFriend == p || firstFriends.contains(secondFriend)){
				continue;
			}

			int mutual = getMutualFriends(p, secondFriend).size();

			maxBound = Math.max(maxBound, mutual);

			secondFriendsMutual.put(secondFriend, mutual);

		}
	}


	ArrayList<Person>[] buckets = new ArrayList[maxBound+1];

	for(Map.Entry<Person, Integer> e : secondFriendsMutual.entrySet()){

		int mutual = e.getValue();

		Person cur = e.getKey();

		if (buckets[mutual] == null){

			buckets[mutual] = new ArrayList<Person>();

		}

		bukets[mutual].add(cur);

	}


	List<Person> result = new ArrayList<Person>();


	for(int i = bukets.length-1; i >= 0; i --){

		if(buckets[i] == null){
			continue;
		}

		for(Person person : buckets[i]){

			result.add(person);

		}

	}

	return result;




	// create a 2d array, buckets
	// bukets[i] -> person with i friends with p









}


