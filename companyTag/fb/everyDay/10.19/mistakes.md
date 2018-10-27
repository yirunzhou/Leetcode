

map.getOrDefault(key, defaultVal)

do not forget to +1

do not forget the defaultVal para


1. next Permutation, RETURN after we cannot find a decending index

	when using if() to rule out something, do not forget to return


2. casting is (className), do not forget the () outside


3. decode ways, first and second do not mix them


4. Seri, Desr BT, check helper function's parameter, every time you call a function, check it parameter is valid or not with your signature

	do not forget to transform your split data into queue!!!

	the queue in Desr is garanteed to be non-empty

	# can help to locate where to return


5. BST -> DDL

	be clear about the function's input and output

	main function return the head of flatten cddl

	connect function connect cddl together

	thus we should convert root to cddl before we pass into the connect function

	BUTTTT!! we should convert after we flatten root.left, root.right

	what happen if we root.left = root, root.right = root before we call flatten(root.right)??? 	==> DEAD LOOP, keep flatten itself


6. find celebirty

while(valid(x) && ..){
	
	while(valid(x) && ...){
		modify(x)
	}

	if(valid(x)){
		f(x)
	}

}