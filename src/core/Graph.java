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

	private ArrayList<Edge> edges;
	private ArrayList<Vertex> vertex;

	public Graph(){
		edges=new ArrayList<>();
		vertex=new ArrayList<>();
		
	}	

	public void addEdge(Edge edge) {
		//Agrega un arco dado al grafo
		edges.add(edge);
	}
	
	public void addVertex(Vertex v){
		vertex.add(v);
	}
	
	public void removeEdge(Edge edge) {
		//No se va a hacer, se deberian borra tmb los nodos pertenecientes
		if (edges.contains(edge))
			edges.remove(edge);
	}
	
	public void removeVertex(Vertex v){
		//No se va a hacer, si un arco lo tiene tambien se borra
		if(vertex.contains(v))
			vertex.remove(v);}
	
	public void changeEdge(Edge e, ArrayList<Attribute>features){
		e.setFeatures(features);	
	}
	
	public void changeVertex(Vertex v,ArrayList<Attribute>features){
		v.setFeatures(features);
		
	}
}
