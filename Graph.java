

import java.util.LinkedList;


public class Graph{
	private HashTable adjList;
	
	private boolean isDirected;

	public Graph(boolean isDirected){
		
		adjList = new HashTable();
	
		this.isDirected = isDirected;

	}

	public void addVertex(Vertex v){
		adjList.put(v, new LinkedList());

	}

	public void removeVertex(Vertex v){
		// Removes the specified vertex from this graph including all its touching edges if present.

		if(isDirected){
			adjList.remove(v);

			return;

		}

		// undirected 

		System.out.println(v.getAllEdges());
		System.out.println(adjList.get(v));
		
		// FIX THIS
		LinkedList myedges = v.getAllEdges();
		for(Object e: myedges){
			Edge thisEdge = (Edge) e;
			System.out.println("THIS EDGE: " + thisEdge);
			System.out.println("destination: -> " + thisEdge.getDestination());


			Vertex link = thisEdge.getDestination();
			System.out.println("LINK " + link);
			for(Object edges: link.getAllEdges()){
				Edge checkEdge = (Edge) edges;

				if(checkEdge.getDestination() == v){
					System.out.println("edge test " + checkEdge);
					link.removeEdge(checkEdge);
					System.out.println(link + " " + " deleting "  + checkEdge.getDestination());
					System.out.println(link + " 's " + link.getAllEdges());
					HashEntry pair = (HashEntry) adjList.get(link);

					LinkedList children = (LinkedList) pair.getValue();
					children.remove(v);
				}

			}

			thisEdge.getDestination().removeEdge(thisEdge);

			
		}

		adjList.remove(v);

	}

	public void addEdge(Vertex source, Vertex dest){
		if(isDirected){

		Edge toConnection = new Edge(source, dest);
		source.addEdge(toConnection);
		HashEntry pair = (HashEntry) adjList.get(source);
		LinkedList chain = (LinkedList) pair.getValue();
		chain.add(dest);


		}
		else{
		// undirected
		Edge toConnection = new Edge(source, dest);
		Edge fromConnection = new Edge(dest, source);
		source.addEdge(toConnection);
		dest.addEdge(fromConnection);

		
		HashEntry pair = (HashEntry) adjList.get(source);
		LinkedList chain = (LinkedList) pair.getValue();
		chain.add(dest);

		 pair = (HashEntry) adjList.get(dest);
		 chain = (LinkedList) pair.getValue();
		 chain.add(source);

		}
	
	
	}
	public void removeEdge(Vertex source, Vertex dest){
		
		Vertex[] vertices = {source, dest};


		if(isDirected){

			System.out.println("To be completed soon-> ");

			return;
		}



		// undirected
		Edge toConnection = new Edge(source, dest);
		Edge fromConnection = new Edge(dest, source);
		source.removeEdge(toConnection);
		dest.removeEdge(fromConnection);

		HashEntry pair = (HashEntry) adjList.get(source);
		LinkedList chain = (LinkedList) pair.getValue();
		chain.remove(dest);

		 pair = (HashEntry) adjList.get(dest);
		 chain = (LinkedList) pair.getValue();
		 chain.remove(source);


	}

	public boolean isDirected(){
		return this.isDirected;
	}

	public int numberOfVertices(){
		return this.adjList.getSize();
	}

	public String toString(){
		return this.adjList.toString();
	}
	

public static void main(String[] args){
	Graph undirectedGraph = new Graph(false);
	Vertex moira = new Vertex("Moira");
	Vertex june = new Vertex("June");
	Vertex luke = new Vertex("Luke");
	Vertex chuck = new Vertex("Chuck");
	Vertex yvonne = new Vertex("Yvonne Strahovski");
	Vertex nathalie = new Vertex("Nathalie");
	undirectedGraph.addVertex(moira);
	undirectedGraph.addVertex(june);
	undirectedGraph.addVertex(luke);
	undirectedGraph.addVertex(chuck);
	undirectedGraph.addVertex(yvonne);
	undirectedGraph.addVertex(nathalie);

	
	undirectedGraph.addEdge(luke, moira);
	//undirectedGraph.addEdge(moira, luke);
	undirectedGraph.addEdge(luke, june);
	//undirectedGraph.addEdge(june, luke);
	undirectedGraph.addEdge(moira, june);
	//undirectedGraph.addEdge(june, moira);
	undirectedGraph.addEdge(yvonne, june);
	undirectedGraph.addEdge(yvonne, chuck);

	System.out.println(undirectedGraph);

	//System.out.println(GraphSearch.hasPathDFS(luke, yvonne));
	GraphSearch.hasPathBFS(luke, chuck);




	}
	
}