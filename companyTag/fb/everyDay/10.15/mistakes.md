
1. main function return result, bfs or dfs no return result

2. three sum set solution: analyze why we need to skip dup, why we will not miss answers

3. max profit (interval) -> count

4. task scheduler -> sort after cd is cleared

5. boolean flag -> remember to flip the flag when you catched something you want

6. while loop, make sure it will terminate

7. diameter of binary tree ->
	main function call helper function
	helper function is to return depth of root
	so helper function cannot be merge into the main function as the return meaning is different

	diameter -> check the meaning of path, diameter, you may miss a 1 or something


8. read4
	
	copy temp -> buf
	buf[bufP ++] = temp[tempP ++]

9. perimeter of island

	visited 	-	seen by cur node's neib

	generated 	-	polled from queue, and generate its neib

	they are different

	VISIT, then MARK

	if we do not mark until generate, we will have dup elements in queue


10. do not forget to update sliding window status when kick out something


11. flatten nestedInteger, if the nested list is empty, then you may have a empty stack back from flatten(peek, stack), 


so if(xxx)
   while(xx)
   if(xxx)

   if we are trying to change a range, or a data structure

   be consistent with the searching range meaning, or keep the ds valid



12. decode ways:

	rowling index:

		consider the cases for len < 3

			1. empty, s.charAt(0) == '0'

			2. i is the index of dp array, so first = s.charAt(i-2), second = s.charAt(i-1)

			3. iterate from [2, s.len()], not [2, dp.len]

			4. reset dp[i%3] before decode

13. max subarray 
	
	initialization, :

		result -> nums[0], it must come from a subarray of nums, not 0!! as max may be a negative number

		sum -> 0, no sum at begining

		min -> 0, no prefix at begining

14. max sum of non-overlapping 3 arrays

	1. what we are trying to get is the starting indexes of 3 arrays

	2. the possible range of the middle array's starting index is [k, len-2\*k]

	3. when we look at the [i, i+k-1] middle array, 

		if we found the max subarray in the range of [0, i-1]
		and in [i+k, len-1]
		then we can update the globle result

	4. now the problem boiled down to how to find the max subarray with size k

	5. we need to dp it, dpLeft[i] is the starting index of max subarray in range[0, i]

		dpRight[i] is the starting index of max subarray in range [i, len-1]

	6. caution when calculating sum, updating dp array
