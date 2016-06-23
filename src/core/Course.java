package core;

import java.util.ArrayList;

import dataBase.DBManager;

/**
 * 
 * @author Team 2.1
 */

public class Course {
	
	private Graph themes;
	private DBManager dbManager;
	
	
	public Course(Graph themes, DBManager dbManager) {
		super();
		this.themes = themes;
		this.dbManager = dbManager;
	}
	
	/***
	 * @param themeName	Nombre del tema nuevo a agregar al curso
	 * @param features	Caracteristicas del tema nuevo
	 * @param fatherThemeName	Nombre del tema correlativo al tema nuevo para establecer la conexion en el grafo
	 * dirigido
	 */
	
	//crear arco
	public void createEdge(String name1, String name2,ArrayList<Attribute>at1,ArrayList<Attribute>at2,ArrayList<Attribute>edgeAt){
		Vertex source=new Vertex(name1);
		Vertex target=new Vertex(name2);
		dbManager.createEdge(name1);
		dbManager.createEdge(name2);
		Edge e=new Edge(source, target);
		e.setFeatures(edgeAt);
		source.setFeatures(at1);
		target.setFeatures(at2);
		themes.removeEdge(e);
		dbManager.createEdge(name1,name2);
	}
	
	//elimina arco
	public void removeEdge(String name1,String name2) {
		Vertex source=new Vertex(name1);
		Vertex target=new Vertex(name2);
		Edge e=new Edge(source, target);
		themes.removeEdge(e);
		dbManager.removeEdge(name1,name2);
	}
	
	//modifica arco->solo se permiten modificar sus atributos
	public void changeEdge(String name1,String name2,ArrayList<Attribute>features) {
		Vertex source=new Vertex(name1);
		Vertex target=new Vertex(name2);
		Edge e=new Edge(source, target);
		themes.changeEdge(e, features);
	}	
	
	//muestra arco
	public void showEdges(){
		themes.showEdges();
	}
	
	//elimina nodo
	public void removeVertex(String name){
		Vertex v=new Vertex(name);
		themes.removeVertex(v);
		dbManager.removeVertex(name);

	}
	
	//modica nodo->solo se permiten modificar sus atributos
	public void changeVertex(String name, ArrayList<Attribute>features){
		Vertex v=new Vertex(name);
		themes.changeVertex(v, features);
	}
	
	//muestra nodos
	public void showVertex(){
		themes.showVertexs();
	}
}