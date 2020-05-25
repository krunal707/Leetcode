public class Graph{

	private HashMap<Integer, Node> nodeLookup = new HashMap<>();

	public static class Node{
		private int id;
		LinkedList<Node> adjecent = new LinkedList<>();
		private Node(int id){
			this.id = id;
		}
	}

	private Node getNode(int id){
		// ??????

	}

	public void addEdge(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		s.adjecent.add(d);
	}

	public boolean hasPathDFS(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<>();
		return hasPathDFS(s, d, visited);
	}
	private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
		if(visited.contains(source.id)){
			return false;
		}
		visited.add(source);
		if(source == destination){
			return true;
		}

		for(Node child : source.adjecent){
			if(hasPathDFS(child, destination, visited)){
				return true;
			}
		}
		return false;
	}

	public boolean hasPathBFS(Node source, Node destination){
		LinkedList<Node> nextToVisit = new LinkedList<>();
		HashSet<Integer> visited = new HashMap<>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			if(node == destination){
				return true;
			}

			if(visited.contains(node.id)){
				continue;
			}

			visited.add(node.id);

			for(Node child: node.adjecent){
				nextToVisit.add(child);
			}


		}
		return false;
	}

}