package dataBase;

import java.util.ArrayList;


//Todo las sentencias SQL se van guardando en changes
//Luego del guardar se ejecuta changes en el postgresql
public class DBManager {
	
	ArrayList<String>changes;
	
	public DBManager(){
		changes = new ArrayList<String>();
	}
	
	public void createVertex(){
		//sentencias jdbc para actualizar esto
	}
	
	public void deleteVertex(){
		//sentencias jdbc para actualizar esto
	}
	
	public void changeVertex(){
		//sentencias jdbc para actualizar esto
	}
	
	public void createEdge(){
		//sentencias jdbc para actualizar esto
	}
	
	public void deleteEdge(){
		//sentencias jdbc para actualizar esto
	}
	
	public void changeEdge(){
		//sentencias jdbc para actualizar esto
	}
	
	public void importGrafo(){
		//sentencias jdbc para esto, usar graphviz
	}
}