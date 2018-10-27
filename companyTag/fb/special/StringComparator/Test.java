public class Test{


	public static void main(String[] args) {
		StringComparator sc = new StringComparator();

		int result = sc.compare(args[0], args[1]);

		System.out.println(args[0]);

		System.out.println(args[1]);

		if(result == 0){
			System.out.println("Same");
		} else if (result > 0){
			System.out.println(args[0] + " is larger");
		} else {
			System.out.println(args[1] + " is larger");
		}
	}


}