
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;


public class Graph {

	/**
	 *	
	 *
	 *	@author Team 2.1 
	*/
	
	private ArrayList<Edge> graph;
	
	public Set<Edge> getAllEdges(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public Edge getEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		for (Edge edge : graph) {
			if (edge.getSource().equals(sourceVertex) && edge.getTarget().equals(targetVertex))
				return edge;
		}
		return null;
	}

	public EdgeFactory<Vertex, Edge> getEdgeFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Edge addEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addEdge(Vertex sourceVertex, Vertex targetVertex, Edge e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addVertex(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsEdge(Edge e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsVertex(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Edge> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Edge> edgesOf(Vertex vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAllEdges(Collection<? extends Edge> edges) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Edge> removeAllEdges(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAllVertices(Collection<? extends Vertex> vertices) {
		// TODO Auto-generated method stub
		return false;
	}

	public Edge removeEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeEdge(Edge e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeVertex(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Vertex> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vertex getEdgeSource(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vertex getEdgeTarget(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getEdgeWeight(Edge e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


