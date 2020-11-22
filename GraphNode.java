import java.util.LinkedList;

public class GraphNode<T>{
	T value;
	LinkedList<GraphNode> children = new LinkedList<>();

	public GraphNode(T value){
		this.value = value;
	}

	public String toString(){
		return value.toString();

	}

	public static void main(String[] args){
		GraphNode myGN = new GraphNode(3);
		GraphNode myGN2 = new GraphNode("California");
		GraphNode myGN3 = new GraphNode(false);

		System.out.println(myGN);
		myGN.children.add(new GraphNode("San Francisco"));
		System.out.println(myGN2);
		System.out.println(myGN3);
		System.out.println(myGN.children);

	}
}