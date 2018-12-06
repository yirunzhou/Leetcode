FindCelebrity.md


Draw a line to help you go through the process


```


public class Solution extends Relation {
    public int findCelebrity(int n) {
        

    	int candidate = 0;

        for(int i = 1; i < n; i ++){

        	if(knows(candidate, i)){
        		candidate = i;
        	}

        }
        // 			c
        //							i
        // 0	1	2	3	4	5	


        // check if c knows 0->n
        // check if 0->n knows c


        for(int i = 0; i < n; i ++){

        	if(candidate != i){

        		if(knows(candidate, i) || !knows(i,candidate)){
        			return -1;
        		}

        	}
        }

        return candidate;
    }
}

```

Variation:

```

collection of objects，只能两两判断大小。只有“大”和“小”, 没有”等“。 然后也没有
transitivity，也就是A > B && B > C 不能推出A > C。 类似石头剪刀布。
要求找出max， max的定义是比其他所有都大。
Find celebrity 变种： max 大于所有数
	
```


