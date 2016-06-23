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
	private ArrayList<Vertex> vertex;//solo para un control interno eviten usarlo!!

	public Graph(){
		edges=new ArrayList<>();
		vertex=new ArrayList<>();		
	}	

	public void addEdge(Edge edge) {
		//Agrega un arco dado al grafo si no existe
		if(notExist(edge)){
			System.out.println("entro1");
			edges.add(edge);}
		else
			//Verifica si el nodo source ya existe en el grafo como parte de un arco
			if(!notExist(edge.getSource())){
				Vertex v1=getVertex(edge.getSource());
				Edge e1=new Edge(v1, edge.getTarget());
				edges.add(e1);
				System.out.println("entro2");}				
			else
					//Verifica si el nodo target ya existe en el grafo como parte de un arco
					if(!notExist(edge.getTarget())){
						Vertex v2=getVertex(edge.getTarget());
						Edge e2=new Edge(edge.getSource(),v2);
						edges.add(e2);
						System.out.println("entro3");
}
	}
	
	private Vertex getVertex(Vertex v) {
		for(int i=0;i<vertex.size();i++)
			if(vertex.get(i).getName().equals(v.getName()))
				return vertex.get(i);
		return null;
	}

	private boolean notExist(Edge edge) {
		for(int i=0;i<edges.size();i++)
			if((edges.get(i).getSource().getName().equals(edge.getSource().getName()))&&(edges.get(i).getTarget().getName().equals(edge.getTarget().getName())))
					return false;
		return true;
	}

	public void addVertex(Vertex v){
		//Agrega un nodo dado al grafo si no existe
		if(notExist(v))
			vertex.add(v);
		else
			System.out.println("El tema ingresado ya existe en el grafo");
	}
	
	private boolean notExist(Vertex v) {
		for(int i=0;i<vertex.size();i++)
			if(vertex.get(i).getName().equals(v.getName()))
				return false;
		return true;
	}

	public void removeEdge(Edge edge) {
		if (edges.contains(edge))
			edges.remove(edge);
		else
			System.out.println("Las correlatividades ingresadas para eliminar no existen en el grafo");

	}
	
	public void removeVertex(Vertex v){
		if(vertex.contains(v))
			vertex.remove(v);
		else
			System.out.println("El tema ingresado para eliminar no existe en el grafo");
	}
	
	//Dado un nodo modifico las caracteriticas
	public void changeEdge(Edge e, ArrayList<Attribute>features){
		if(edges.contains(e))
			e.setFeatures(features);	
		else
			System.out.println("Las correlatividades ingresadas para modificar sus atributos no existe en el grafo");					
	}
	
	//Dado un arco modifico las caracteristicas
	public void changeVertex(Vertex v,ArrayList<Attribute>features){
		if(vertex.contains(v))
			v.setFeatures(features);
		else
			System.out.println("El tema ingresado para modificar sus atributos no existe en el grafo");					
	}

	public void showVertexs() {
		System.out.println("Temas: ");
		for(int i=0;i<vertex.size();i++)
			System.out.println(vertex.get(i).getName());
	}
	
	public void showEdges() {
		for(int i=0;i<edges.size();i++){
			System.out.println(edges.get(i).getSource().getName()+" --> "+edges.get(i).getTarget().getName());
		}
	}
}
