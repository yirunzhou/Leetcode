public class CloneGraph{

	public List<Node> clone(List<Node> graph){

		/**
			copy nodes
			copy links
		*/


		Map<Node, Node> mapping = new HashMap<>();

		List<Node> result = new ArrayList<>();

		for(Node n : graph){
			Node copy = new Node(n.label);
			mapping.put(n, copy);
			result.add(copy);
		}

		for(Entry<Node, Node> e : mapping.entrySet()){
			Node copy = e.getValue();
			Node orig = e.getKey();

			List<Node> origNeighbors = orig.neighbors;

			for(Node on : origNeighbors){
				copy.neighbors.add(mapping.get(on));
			}

		}

		return result;
	}


	public static void main(String[] args) {
		
	}
}