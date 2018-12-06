Kth Largest Element in an Array.md


Mistakes :

	1. Parition function, be careful about the index name

	2. Runtime analysis, ave O(n), worst case O(n^2), but could use shuffle function to be O(n)

	3. Runtime of PQ solution:

		construct a k-size min-heap, iterate the rest of array, if larger than peek, poll, offer

		O(nlogk)

		space : O(k)

	



```
	public int KthLargest(int[] nums, int k){

		k = nums.length- k;

		int lo = 0;
		int hi = nums.length-1;


		/**
			[0, lo) is the number that < kth
			(hi, len-1] is. number. that > kth
		*/

		while(lo <= hi){


			int pos = split(nums, lo, hi);

			//(lo, pos] < (pos, hi]

			if(pos == k){

				return nums[k];

			} else if(pos > k){

				hi = pos - 1;

			} else {

				lo = pos + 1;

			}

		}

		return nums[lo];

	}


	// find the right position for the pivot
	private int split(int[] nums, int lo, int hi){

		int pivot = nums[lo];


		int l = lo;
		int r = hi;

		// [lo, l) <= pivot
		// (r, hi) > pivot

		while(l <= r){

			while(r >= l && nums[r] > pivot){
				r --;
			}

			while(r >= l && nums[l] <= pivot){
				l ++;
			}

			if(l <= r){
				swap(nums, l, r);
			}

		}


		swap(nums, l-1, lo);

		return l-1;

	}

	private void swap(int[] nums,  int i, int j){

		int t = nums[i];

		nums[i] = nums[j];

		nums[j] = t;
	}



```

```
	public int KthLargest(int[] nums, int k){

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0; i < k; i ++){
			pq.offer(nums[i]);
		}

		for(int i = k; i < nums.length; i ++){

			if(pq.peek() < nums[i]){
				pq.poll();
				pq.offer(nums[i]);
			}

		}

		return pq.peek();
	}


