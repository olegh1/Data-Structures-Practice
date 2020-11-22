
public class Edge{
	private Vertex source;
	private Vertex destination;

	public Edge(Vertex source, Vertex destination){
		this.source = source;
		this.destination = destination;
	}

	public Vertex getSource(){
		return this.source;
	}

	public Edge getEdge(){
		return this;
	}

	public Vertex getDestination(){
		return this.destination;
	}

	public void setSource(Vertex newSource){
		this.source = newSource;
	}

	public void setDestination(Vertex newDestination){
		this.destination = newDestination;
	}

	public String toString(){
		return source.toString() + " -> " + destination.toString();
	}

}