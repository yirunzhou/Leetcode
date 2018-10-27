Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].


Output :
list of Person's accounts -> [name, email1, email2 .... (order)]

A person -> one name, different emails

1. email -> name map

2. 

	union emails of the same list


	  1
	/\	\
	2 3	5
	\
	4

3.

	iterate over input's accounts, find ancestor, put into ancestor -> [name, emails] map




class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
    	Map<String, String> nameMap = nameMap(accounts);

    	// union emails in same list
    	UF uf = new UF(accounts);

    	unionInSameList(uf, accounts);

    	// one group in uf as a sublist
    	List<List<String>> result = getResult(uf, accounts, nameMap);

    	return reuslt;

    }

    private Map<String, String> nameMap(List<List<String>> accounts){

    	Map<String, String> nameMap = new HashMap<>();

    	for(List<String> list : accounts){

    		for(int i = 1; i < list.size(); i ++){

    			nameMap.put(list.get(i), list.get(0));

    		}

    	}

    	return nameMap;
    }


    private Map<String, Set<String>> getResult(UF uf, List<List<String>> accounts, Map<String, String> nameMap){
    	
    	Map<String, Set<String>> resultMap = new HashMap<>();

    	// ancestor as key, its children list as value

    	for(List<String> list : accounts){

    		for(int i = 1; i < list.size(); i ++){

    			// iterate over all the emails, find the ancestor, put into map
    			String cur = list.get(i);


    			String ancestor = uf.find(cur);

    			if(!resultMap.containsKey(ancestor)){
    				resultMap.put(ancestor, new TreeSet<String>());
    			}

    			resultMap.get(ancestor).add(cur);
    		}

    	}


    	// step2 : add name, then add the set

    	List<List<String>> resultList = new ArrayList<>();

    	for(Map.Entry<String, Set<String>> e : map.entrySet()){

    		List<String> subList = new ArrayList<>();

    		subList.add(nameMap.get(e.getKey()));

    		subList.addAll(e.getValue());
    	}

    	return resultList;
    }

    private void unionInSameList(UF uf, List<List<Integer>> accounts){

    	for(List<String> list : accounts){

    		// union to the first email of the sublist
    		
    		for(int i = 1; i < list.size(); i ++){
    			uf.union(list.get(i), list.get(1));
    		}

    	}

    }


    private class UF{

    	Map<String, String> parent = new HashMap<>();

    	Map<String, Integer> size = new HashMap<>();


    	public UF(List<List<String>> accounts){

    		for(List<String> list : accounts){

    			for(int i = 1; i < lists.size(); i ++){
    				// init isolated emails
    				parent.put(list.get(i), list.get(i));

    				parent.put(list.get(i), 1);

    			}

    		}

    	}

    	public void union(String s1, String s2){

    		String s1r = find(s1);
    		String s2r = find(s2);

    		if(s1r.equals(s2r)){
    			return;
    		}

    		if(size.get(s1r) < size.get(s2r)){

    			parent.put(s1r, s2r);
    			size.put(s2r, size.get(s2r) + size.get(s1r));

    		} else {

    			parent.put(s2r, s1r);
    			size.put(s1r, size.get(s1r) + size.get(s2r));

    		}


    	}

    	public String find(String s){

    		while(!parent.get(s).equals(s)){

    			parent.put(s, parent.get(parent.get(s)));

    			s = parent.get(s);
    		}

    		return s;
    	}

    }

}