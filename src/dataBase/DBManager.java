package dataBase;

import java.util.ArrayList;


//Todo las sentencias SQL se van guardando en changes
//Luego del guardar se ejecuta changes con jdbc
public class DBManager {
	
	ArrayList<String>changes;
	
	public DBManager(){
		changes = new ArrayList<String>();
	}

	public void createEdge(String name1) {
		// TODO Auto-generated method stub
		
	}

	public void createEdge(String name1, String name2) {
		// TODO Auto-generated method stub
		
	}

	public void removeEdge(String name1, String name2) {
		// TODO Auto-generated method stub
		
	}

	public void removeVertex(String name) {
		// TODO Auto-generated method stub
		
	}
	
	//Las eliminaciones pueden quedar para el siguiente sprint
	//Las modificaciones de los atributos quedaran para el siguiente sprint	
}
