


// return the string representation of the list, and its end

// [412,241,[2131412,[412421]],44214]
private static final Strin SEP = ",";




public String serialize(List<NestedInteger> nestedList){

	StringBuilder builder = new StringBuilder();

	builder.append("[");


	for(NestedInteger ni : nestedList){

		if(ni.isInteger()){

			builder.append(ni.getInteger());

			builder.append(SEP);

		} else {

			builder.append(helper(ni.getList()));

			builder.append(SEP);

		}

	}

	builder.append("]");

	return builder.toString();
}


public NestedInteger deserialize(String input){

	return helper(input, 0);

}


// return the wrapper result of endIndex, List<JSON>
public Result helper(String input, int startIndex){

	int curIndex = startIndex;

	NestedInteger builder = new NestedInteger<>();


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
			// SEP

			builder.add(tempNumber);

			tempNumber = 0;

			seenNumber = false;

		}

	}

	if(seenNumber){
		builder.add(tempNumber);
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



/*
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }






