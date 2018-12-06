import java.util.*;



public class KthClosestPoints{

	private Point[] points;

	private Random rand;


	public List<Point> find(int k){

		// to find [0, k]
		k -= 1;

		// [0, lo) < points[k]
		// (hi, len-1] > points[k]

		int lo = 0;
		int hi = points.length-1;

		while(lo <= hi){

			// place the points[lo] to the right position, return its position

			int pos = split(points, lo, hi);

			if(pos == k){

				break;

			} else if(pos > k){

				// pos seperate [0, pos],  (pos, len-1)
				// points[pos] as pivot
				// so searching range is [0, pos)
				hi = pos - 1;

			} else {

				// pos < k

				// (pos, hi]

				lo = pos + 1;

			}

		}

		List<Point> result = new ArrayList<>();

		for(int i = 0; i <= k; i ++){
			result.add(points[i]);
		}

		print(points);

		System.out.printf("\nResult of %d closest are  :\n", k+1);

		System.out.println(result);

		return result;

	}


	private int split(Point[] points, int lo, int hi){

		Point pivot = points[lo];

		int pivotD = pivot.getDistance();

		int l = lo;
		int r = hi;


		while(l <= r){
			while(l<= r && points[r].getDistance() > pivotD){
				r --;
			}

			while(l<= r && points[l].getDistance() <= pivotD){
				l ++;
			}

			if(l <= r){
				swap(points, l, r);
			}
		}


		swap(points, lo, l-1);

		
		return l-1;

	}

	private void swap(Point[] points, int i, int j){
		Point t = points[i];
		points[i] = points[j];
		points[j] = t;
	}



	private class Point{

		public int x;
		public int y;

		public Point(int _x, int _y){
			x = _x;
			y = _y;
		}

		public int getDistance(){
			return x*x + y*y;
		}


		@Override
		public String toString(){
			return String.format("[ %d, %d ]", x, y);
		}
	}


	



	
	public KthClosestPoints(int n){

		points = new Point[n];

		rand = new Random();

		generate(n);

	}


	private void generate(int n){
		while(n-- > 0){
			points[n] = new Point(rand.nextInt(20), rand.nextInt(20));
		}
	}




	private void print(Point[] points){
		for(Point p: points){
			System.out.print(p);
		}
		System.out.println();
	}



	public static void main(String[] args) {
			
		KthClosestPoints test = new KthClosestPoints(8);

		test.find(4);

	}

}