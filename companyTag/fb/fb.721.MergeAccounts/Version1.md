

```
public List<List<String>> accountsMerge(List<List<String>> accounts) {

    UF uf = new UF(accounts);

    // union all the email in one account
    for(List<String> account : accounts){
    	for(int i = 1; i < account.size(); i ++){
    		for(int j = i+1; j < account.size(); j ++){
    			uf.union(account.get(i), account.get(j));
    		}
    	}
    }

    Map<String, Set<String>> rootsToSet = new HashMap<>();

    // find the root of every email, put into TreeSet
	for(List<String> account : accounts){
    	for(int i = 1; i < account.size(); i ++){
    		
    		String root = uf.find(account.get(i));

    		Set<String> set = null;

    		if(!rootsToSet.containsKey(root)){
    			set = new TreeSet<String>();
    			rootsToSet.put(root, set);
    		} else {
    			set = rootsToSet.get(root);
    		}

    		set.add(account.get(i));
    	}
    }


    List<List<String>> result = new ArrayList<>();

    for(String root : rootsToSet.keySet()){
    	List<String> sub = new ArrayList<String>()
    	result.add(sub);
    	sub.add(uf.getName(root));
    	sub.addAll(rootsToSet.get(root));
    }

    return result;

}


private class UF{

	Map<String, String> parent = new HashMap<>();
	Map<String, String> name = new HashMap<>();

	// child -> parent
	// email -> name

	public UF(List<List<String>> accounts){
		for(List<String> account : accounts){
			for(int i = 1; i < account.size(); i ++){
				parent.put(account.get(i), account.get(i));
				name.put(account.get(i), account.get(0));
			}
		}
	}

	public String getName(String s){
		return name.get(s);
	}

	public String find(String s){
		if(map.get(s).equals(s)){
			return s;
		}
		String parentStr = find(map.get(s));
		map.put(s, parentStr);
		return parentStr;
	}

	public void connected(String s1, String s2){
		return find(s1).equals(find(s2));
	}

	public void union(String s1, String s2){
		String r1 = find(s1);
		String r2 = find(s2);

		if(r1.equals(r2)){
			return;
		}
		map.put(r1, r2);
	}
}