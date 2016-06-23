package dataBase;

import java.util.ArrayList;

//EDGE = ARCO - VERTEX = NODO

//Todo las sentencias SQL se van guardando en changes

//Luego del guardar se ejecuta changes con jdbc

public class DBManager {
	
	private ArrayList<String> changes;
	

	
	public void createEdge(int id_source, int id_target) {   //Agregar datos a la tabla correlatividades
		
		String query = "INSERT INTO correlatividades(antecesor, sucesor) VALUES (" + id_source + ", " + id_target + ");";      
		
		this.changes.add(query); 
		
	}

	public void createVertex(String name, int id) {  //Agrego datos a la tabla temas
		
		//Si voy a crear un arco, ya tiene que estar creado el nodo verdad?, o se va a poner la posibilidad de crear un arco y si el nodo no existe se agrega?
		
		String query = "INSERT INTO temas(id_tema, nombre_tema) VALUES (" + id + ", '" + name + "')" + ";" ;
		
		this.changes.add(query); 	
		
	}

	public void removeEdge(int id_source, int id_target) { //Eliminar un registro de la tabla correlatividades
		
		String query = "DELETE FROM correlatividades WHERE (antecesor = " + id_source + " AND sucesor = " + id_target + ";";
		
		this.changes.add(query);
	}

	public void removeVertex(int id) { //Eliminar un registro de la tabla temas
	    
		//Si elimino un tema(nodo) que hacemos con el arco?, se borra o se pone a null el origen o destino respectivamente.
		
		String query = "DELETE FROM temas WHERE id_tema = " + id + ";";
		
		this.changes.add(query);
	}
	
	
	//Las eliminaciones pueden quedar para el siguiente sprint
	//Las modificaciones de los atributos quedaran para el siguiente sprint	
}
