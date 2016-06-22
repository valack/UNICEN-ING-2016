package core;

import java.util.ArrayList;

import dataBase.DBManager;


public class Course {
	
	private Graph themes;
	private DBManager dbManager;
	
		
	public Course(Graph themes, DBManager dbManager) {
		super();
		this.themes = themes;
		this.dbManager = dbManager;
	}
	
	public void addTheme(String themeName, ArrayList<Attribute> features, String fatherThemeName){
		Vertex sourceTheme = new Vertex(fatherThemeName);
		Vertex newTheme = new Vertex(themeName);
		Edge edge = new Edge(sourceTheme, newTheme, features);
		themes.addEdge(edge);
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