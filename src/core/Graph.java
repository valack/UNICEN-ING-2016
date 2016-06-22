package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


public class Graph {

	/**
	 *	Grafo dirigido y aciclico para modelar un curso con sus temas
	 *	Cada nodo es un tema y cada arco una dependencia de correlatividad	
	 *
	 *	@author Team 2.1 
	 */

	private ArrayList<Edge> graph;


	
	public ArrayList<Edge> getAllEdges(Vertex sourceVertex, Vertex targetVertex) {
		//Obtiene todos los arcos del grafo
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (Edge edge : graph) {
			edges.add(edge);
		}
		return edges;
	}

	public Edge getEdge(Vertex sourceVertex, Vertex targetVertex) {
		//Obtiene el arco correspondiente a los vertices fuente y destino del mismo
		for (Edge edge : graph) {
			if (edge.getSource().equals(sourceVertex) && edge.getTarget().equals(targetVertex))
				return edge;
		}
		return null;
	}

	public void addEdge(Edge edge) {
		//Agrega un arco dado al grafo
		graph.add(edge);
	}

	public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex) {
		for (Edge edge : graph) {
			if (edge.getSource().equals(sourceVertex) && edge.getTarget().equals(targetVertex))
				return true;
		}
		return false;
	}

	public boolean containsEdge(Edge edge) {
		return graph.contains(edge);
	}

	public boolean containsVertex(Vertex v) {
		for (Edge edge : graph) {
			if (edge.getSource().equals(v) || edge.getTarget().equals(v))
				return true;
		}
		return false;
	}

	public ArrayList<Edge> edgesOf(Vertex vertex) {
		if (containsVertex(vertex))	{
			ArrayList<Edge> edges = new ArrayList<Edge>();
			for (Edge edge : graph) {
				if (edge.getSource().equals(vertex))
					edges.add(edge);
			}
			return edges;
		}
		else
			return null;
	}

	public void removeEdge(Edge edge) {
		if (containsEdge(edge))
			graph.remove(edge);
	}

	public Vertex getVertex(String vertexName) {
		for (Edge edge : graph) {
			if (edge.getSource().getName().equals(vertexName))
				return edge.getSource();
			else
				if (edge.getTarget().getName().equals(vertexName))
					return edge.getTarget();
		}
		return null;
	}

}
