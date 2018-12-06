/**
    Memo dfs

    1. imagine the recursion tree

    2. the larger result is based one the smaller result

    3. and there are many duplication status in dfs

    4. thus make the status as key, the smaller problem's result as value, do memo dfs

    5. memo dfs return the direct result for what the question ask for
    
    6. base case is we reached the end, what we should return to satisfy larger problems?

        in this case it will be a list contains "", thus the larger problem call the base case, it will return the right result


*/


class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        // loop through wordDict, to see if the [index, index + word.length) is word, is then add to temp list
        // until the index is point to the s.length
        // memo search, the return val is based on latter result
        
        return dfs(wordDict, s, 0, new HashMap<Integer, List<String>>());
    }
    
    // [pointer, len-1] is need to match, if there is already some answer, then append each one of the answer
    public List<String> dfs(List<String> wordDict, String s, int pointer, Map<Integer, List<String>> memo){
        
        // the things need to append is in the map
        if(memo.containsKey(pointer)){
            return memo.get(pointer);
        }
        
        // base
        if(pointer == s.length()){
            List<String> cur = new ArrayList<>();
            cur.add("");
            memo.put(pointer, cur);
            return cur;
        }
        
        // not the end and not in memo, return [pointer, s.len-1]'s result
        // if no match then is empty list
        List<String> cur = new ArrayList<>();
        
        for(String word : wordDict){
            if(pointer + word.length() > s.length()) continue;
            
            String toMatch = s.substring(pointer, pointer + word.length());
            
            if(toMatch.equals(word)){
                List<String> subresult = dfs(wordDict, s, pointer+word.length(), memo);
                for(String sub : subresult){
                    cur.add((word + " " + sub).trim());
                }
            }
        }
        
        memo.put(pointer, cur);
        return cur;
    }
}