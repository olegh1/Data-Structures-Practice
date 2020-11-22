

public class GraphSearch {

	private static HashTable visited = new HashTable();
	private static boolean found = false;

	public static boolean hasPathDFS(Vertex from, Vertex to){
		// starts at some vertex and searches all of its neighbors


		return DepthFirstSearch(from, to);

	}

	public static boolean DepthFirstSearch(Vertex source, Vertex dest){

			visited.put(source, true);

			if(source.getData() == dest.getData()){
				System.out.println(source.getData() + "  == " + dest.getData());
				found = true;
				return true;
			}

			if(source.getAllEdges().size() == 0){
				return false;
			}


			for(Object edge: source.getAllEdges()){
				Edge connection = (Edge) edge;
				Vertex child = connection.getDestination();
				System.out.println(child);
				if(visited.exists(child)){
					System.out.println(child + " has already been visited");
				}

				else{

				DepthFirstSearch(child, dest);
			}
		}

			


		return found;

	}

	public static boolean hasPathBFS(Vertex from, Vertex to){
		// Breadth first search representation 

		return BreadthFirstSearch(from, to);
	}

	public static boolean BreadthFirstSearch(Vertex source, Vertex dest){
		Queue myQ = new Queue();
		// BFS is level by level

		

		for(Object edge: source.getAllEdges()){
			Edge connection = (Edge) edge;
			Vertex child = connection.getDestination();
			System.out.println(child);
			myQ.add(child);
		}

		System.out.println(myQ.toString());
		return false;
	}



	public static void main(String[] args){
		System.out.println("Depth First Search");

		System.out.println("Undirected Graph \n");

		
		


	}
}