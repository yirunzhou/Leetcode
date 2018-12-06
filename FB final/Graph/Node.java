import java.util.*;


public class Node{
	int label;
	List<Node> neighbors;

	public Node(int n){
		label = n;
		neighbors = new ArrayList<>();
	}

	public void print(){

		System.out.printf("Node label %d , children list: ", label);

		for(Node n : neighbors){

			System.out.printf("%d, ", n.label);

		}

		System.out.println();
	}

	public static void main(String[] args) {
		Node test = new Node(10);

		Node testChild = new Node(100);

		Node testChild2 = new Node(1002);

		test.neighbors.add(testChild);
		test.neighbors.add(testChild2);

		test.print();
	}


}