import java.util.HashSet;

public class Coordinate{
	public int x;
	public int y;

	public Coordinate(int _x, int _y){
		x = _x;
		y = _y;
	}

	public int hashCode(){
		return 31*x + y;
	}

	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}

		if(!(o instanceof Coordinate)){
			return false;
		}

		Coordinate c = (Coordinate) o;
		return c.x == this.x && c.y == this.y;
	}

	public static void main(String[] args) {
		HashSet<Coordinate> set = new HashSet<>();
		Coordinate c1 = new Coordinate(1, 2);
		Coordinate c2 = new Coordinate(1, 2);

		set.add(c1);
		System.out.println(set.add(c2));
	}
}