package core;

import java.sql.SQLException;
import java.util.ArrayList;

import core.graphModel.Attribute;
import core.graphModel.Edge;
import core.graphModel.Graph;
import core.graphModel.Vertex;
import dataBase.*;

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
	
	public Course(DBManager dbManager) {
		themes = new Graph();
		this.dbManager = dbManager;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}

	/***
	 * @param themeName	Nombre del tema nuevo a agregar al curso
	 * @param features	Caracteristicas del tema nuevo
	 * @param fatherThemeName	Nombre del tema correlativo al tema nuevo para establecer la conexion en el grafo
	 * dirigido
	 */
	
	//crear arco
	public void createCorrelative(String name1, String name2,ArrayList<Attribute>at1,ArrayList<Attribute>at2,ArrayList<Attribute>edgeAt){
	
		Vertex source = new Vertex(name1);
		Vertex target = new Vertex(name2);

		if (!this.themes.exist(source))
		{
			try {
				dbManager.createVertex(name1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
			
		if (!this.themes.exist(target))
		{
			try {
				dbManager.createVertex(name2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		Edge e=new Edge(source, target);
//		e.setFeatures(edgeAt);
//		source.setFeatures(at1);
//		target.setFeatures(at2);
		
		dbManager.createEdge(name1, name2);
		
		themes.addEdge(e);
	}
	
	//elimina arco
	public void removeCorrelative(String name1,String name2) {
		Vertex source = new Vertex(name1);
		Vertex target = new Vertex(name2);
		Edge e=new Edge(source, target);
		themes.removeEdge(e);
		dbManager.removeEdge(name1, name2);
	}
	
	//modifica arco->solo se permiten modificar sus atributos
	public void changeCorrelative(String name1,String name2,ArrayList<Attribute>features) {
		Vertex source=new Vertex(name1);
		Vertex target=new Vertex(name2);
		Edge e=new Edge(source, target);
		themes.changeEdge(e, features);
	}	
	
	//muestra arco
	public void showCorrelative(){
		themes.showEdges();
	}
	
	//elimina nodo
	public void removeThemes(String name){
		Vertex v = new Vertex(name);
		themes.removeVertex(v);
		dbManager.removeVertex(name);

	}
	
	//modica nodo->solo se permiten modificar sus atributos
	public void changeThemes(String name, ArrayList<Attribute>features){
		Vertex v=new Vertex(name);
		themes.changeVertex(v, features);
	}
	
	//muestra nodos
	public void showThemes(){
		themes.showVertexs();
	}

	public ArrayList<Edge> getCorrelative() {
		return themes.getEdges();
	}

}