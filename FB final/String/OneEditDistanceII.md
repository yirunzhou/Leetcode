
class IntFileIterator {
  boolean hasNext();
  int next();
}

class FileCompare {
  public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b)；

}


public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b, int count){
    if(!a.hasNext && !b.hasNext) return true;

    if(count > 1) return false;

	if(a == b) return isDistanceZeroOrOne(a.next, b.next, count);

     return isDistanceZeroOrOne(a.next, b.next, count + 1) // replace
     || isDistanceZeroOrOne(a, b.next, count + 1) 	// insert a
     || isDistanceZeroOrOne(a.next, b, count + 1);	// insert b

     // and update the count

     /**		
     a
		1	2	2	1
		1	2	1
     */

}