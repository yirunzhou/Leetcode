

buy and sell stock

encode decode nested string!!!


leftmost

validate bst
bst inorder iterator
Symmetric Tree
题目是给一个Array of Nodes，每个node有left和right的child，求问这些node能不能组成一个二叉树
257	tree path


pizza



211. Add and Search Word - Data structure design
146. LRU Cache
	
Longest Increasing Subsequence

random pop with o1
	
Design Tic-Tac-Toe


Word Break

N queen

3Sum no sorting

insert interval 



String -> Interval

reverse word in a sentence

add string hex

randomly return the. index of the max of array	

min window. substring -> unique or. not




class IntFileIterator {
  boolean hasNext();
  int next();
}

class FileCompare {
  public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b)；. from: 1point3acres 
来源一亩.三分地论坛. 
}
// return if the distance between a and b is at most 1.
// Distance: minimum number of modifications to make a=b. from: 1point3acres 
// Modification:. 一亩-三分-地，独家发布
//   1. change an int in a
//   2. insert an int to a
//   3. remove an int from a


public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b, int count){
     if(!a.hasNext && !b.hasNext) return true;. 一亩-三分-地，独家发布
     if(count > 1) return false;
if(a == b) return isDistanceZeroOrOne(a.next, b.next, count);. 牛人云集,一亩三分地
     return isDistanceZeroOrOne(a.next, b.next, count + 1) || isDistanceZeroOrOne(a, b.next, count + 1) || isDistanceZeroOrOne(a.next, b, count + 1)
相当于两个指针一直移动， 都为空的时候为真，如果修改大于1位false
}





