import java.util.LinkedList;

public class Vertex{
	// aka like a Node 
	private Object data;
	private String name;
	private LinkedList<Edge> edges;

	public Vertex(Object data){
		this.data = data;
		this.name = data.toString();
		this.edges = new LinkedList<>();
	}

	public Object getData(){ return this.data;}
	
	public String toString(){
		return this.name;
	}

	public LinkedList getAllEdges(){
		return this.edges;
	}

	public void addEdge(Edge connection){
		this.edges.add(connection);
	}

	public boolean removeEdge(Edge connection){
		return this.edges.remove(connection);

	}

public static void main(String[] args){

	Vertex one = new Vertex(23);
	
	}
}