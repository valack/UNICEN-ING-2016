package core.graphModel;

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

	public Graph(){
		edges=new ArrayList<>();
	}	

	public void addEdge(Edge edge) {
		//Agrega un arco dado al grafo si no existe
		if(notExist(edge)){ 
			edges.add(edge);}
		else
			System.out.println("El arco ya existe");			
			/*//Verifica si el nodo source ya existe en el grafo como parte de un arco
			if(exist(edge.getSource())){
				Vertex v1=getVertex(edge.getSource());
				Edge e1=new Edge(v1, edge.getTarget());
				edges.add(e1);
				System.out.println("entro2");}
			else
					//Verifica si el nodo target ya existe en el grafo como parte de un arco
					if(exist(edge.getTarget())){
						Vertex v2=getVertex(edge.getTarget());
						Edge e2=new Edge(edge.getSource(),v2);
						edges.add(e2);
						System.out.println("entro3");}*/
	}
	
	
	//Metodo auxiliar
	private Vertex getVertex(Vertex v) {
		//Devuelve el nodo del vector arcos que se corresponde con v
		for(int i=0;i<edges.size();i++)
			return edges.get(i).getVertex(v);
		return null;
	}

	//Metodo auxiliar
	private boolean exist(Vertex v) {
		//Verifica si el nodo existe en algun arco
		for(int i=0;i<edges.size();i++)
			return edges.get(i).existInEdge(v);
		return false;
	}

	public void removeEdge(Edge edge) {
		if (edges.contains(edge))
			edges.remove(edge);
		else
			System.out.println("Las correlatividades ingresadas para eliminar no existen en el grafo");
	}
	
	//Dado un arco se puede modificar solo los atributos
		public void changeEdge(Edge e, ArrayList<Attribute>features){
			if(edges.contains(e))
				e.setFeatures(features);	
			else
				System.out.println("Las correlatividades ingresadas para modificar sus atributos no existe en el grafo");					
		}
		
	//Metodo auxiliar
	private boolean notExist(Edge edge) {
		for(int i=0;i<edges.size();i++)
			if((edges.get(i).getSource().getName().equals(edge.getSource().getName()))&&(edges.get(i).getTarget().getName().equals(edge.getTarget().getName())))
					return false;
		return true;
	}
	
	
	public void showEdges() {
		for(int i=0;i<edges.size();i++){
			System.out.println(edges.get(i).getSource().getName()+" --> "+edges.get(i).getTarget().getName());
		}
	}
	

	public void removeVertex(Vertex v){
		for(int i=0;i<edges.size();i++)
			edges.get(i).removerVertex(v);
	}
	
	
	//Dado un nodo se puede modificar solo los atributos
	public void changeVertex(Vertex v, ArrayList<Attribute>features){
		for(int i=0;i<edges.size();i++)
			edges.get(i).changeVertex(v,features);
	}

	
	public void showVertexs() {
		ArrayList<String> marks = new ArrayList<>();
		String source = "";
		String target = "";
		System.out.println("Temas: ");
		for(int i=0;i<edges.size();i++)	{
			source = edges.get(i).getSource().getName(); 
			target = edges.get(i).getTarget().getName();
			if (!marks.contains(source))	{
				System.out.println(source);
				marks.add(source);
			}
			if (!marks.contains(target)){
				System.out.println(target);
				marks.add(target);
			}
		}
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
}
