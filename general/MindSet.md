


When changing multiple variables, try to make it atomatic

change ONE variable might have effect on OTHERS

	nextX = f1(nextX, nextY)
	nextY = f2(nextX, nextY) 

	-> error!!!
	as I have changed nextX, but assume not changing it when updating nextY

