

/**
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.



	for shortest distance to stop at destination

	it is not normal level order bfs can do, as each level the ball may move different distances

	thus same level's path reach the same point may have different distances

	thus move to the same point again is not equal to have a longer distance

	thus need a distance array [][]

	only when reaches this point with a longer distance we do not further start bfs

*/


