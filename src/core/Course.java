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
	public void addTheme(String themeName, ArrayList<Attribute> features, String fatherThemeName){
		Vertex sourceTheme = themes.getVertex(fatherThemeName);
		Vertex newTheme = new Vertex(themeName);
		Edge edge = new Edge(sourceTheme, newTheme, features);
		themes.addEdge(edge);
	}
	/**
	 * Agrega un tema sin un tema correlativo. Es decir, que puede ser la raiz del grafo o puede ser un tema que
	 * se puede compreder sin conocer ningún otro tema del curso
	 * @param themeName
	 * @param features
	 */
	public void addTheme(String themeName, ArrayList<Attribute> features){
		Vertex newTheme = new Vertex(themeName);
		Edge edge = new Edge(null, newTheme, features);
		themes.addEdge(edge);
	}
	
	public void deleteTheme(String themeName){
		//TODO
	}
	
	
	public Graph getThemes() {
		return themes;
	}
	
	public void setThemes(Graph themes) {
		this.themes = themes;
	}
	
	public DBManager getDbManager() {
		return dbManager;
	}
	
	public void setDbManager(DBManager dbManager) {
		this.dbManager = dbManager;
	}
	
}