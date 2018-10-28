

Serialize :

	if null?

	else call helper to return the string

		CASE1: integer
		CASE2: list


Deserialize: 

	input not start with [ -> number

	else call helper to decode string after [

	


```

class Solution {
    
    
    private static final String SEP = ",";




    public String serialize(NestedInteger input){
        
        if(input == null){
            return "";
        }
        
        String result = helperSer(input);
        
        return result;
    }
    
    
    public String helperSer(NestedInteger input){
        
        if(input.isInteger()){
            return String.valueOf(input.getInteger());
        }
        
        // else if this is a list
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        
        List<NestedInteger> list = input.getList();
        
        // iterate the list and append 
        
        for(int i = 0; i < list.size(); i ++){
            
            builder.append(helperSer(list.get(i)));
            
            if(i != list.size() - 1){
                builder.append(SEP);
            }
            
        }

        builder.append("]");

        return builder.toString();
        
    }

    
    public NestedInteger deserialize(String input){

        if(input.length() == 0){
            return null;
        }
        
        if(input.charAt(0) != '['){
            // input is a integer
            return new NestedInteger(Integer.valueOf(input));
        }
        
        return helper(input, 1).content;

    }

    // input is a list, and starts from the first char after [
    // return the wrapper result of endIndex and the content
    
    public Result helper(String input, int startIndex){
        
        int curIndex = startIndex;

        NestedInteger builder = new NestedInteger();
        
        // store the number that need to be add into builder
        int tempNumber = 0;
        
        boolean seenNumber = false;
        
        
        

        for(; curIndex < input.length(); curIndex ++){

            char cur = input.charAt(curIndex);
            

            if(cur == '['){

                Result subresult = helper(input, curIndex + 1);

                builder.add(subresult.content);

                curIndex = subresult.endIndex;

            } else if (cur == ']'){

                break;

            } else if (Character.isDigit(cur)){

                tempNumber = tempNumber * 10 + (cur - '0');

                seenNumber = true;

            } else {
                // SEP, maybe the previous is a list, so if(seenNumber),
                
                if(seenNumber) builder.add(new NestedInteger(tempNumber));
                
                tempNumber = 0;

                seenNumber = false;

            }

        }

        if(seenNumber){
            builder.add(new NestedInteger(tempNumber));
        }
        
        
        return new Result(curIndex, builder);
        
    }

    private class Result{

        public int endIndex;

        public NestedInteger content;

        public Result(int e, NestedInteger ni){

            endIndex = e;

            content = ni;

        }

    }

```