package dataBase;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//Todo las sentencias SQL se van guardando en changes

//Luego del guardar se ejecuta changes con jdbc

public class DBManager {
	
	private ArrayList<String> changes;
	
	private ConnectionPostgresql cn;
	
	public DBManager(ConnectionPostgresql cn)
	{
		this.cn = cn;
		this.changes = new ArrayList<String>();
	}
	
	public void saveBD()
	{
		for(String s: changes)
			System.out.println(s);
		
		this.cn.executeQuerys(changes);
	}
	
	public void cleanDB()
	{
		ArrayList<String> aux = new ArrayList<String>(); 
		String query = "DELETE FROM correlatividades; DELETE FROM temas;";
		aux.add(query);		
		this.cn.executeQuerys(aux);
	}
	
	
	public void createEdge(String source, String target) {   //Agregar datos a la tabla correlatividades
		
		String query = "INSERT INTO correlatividades(antecesor, sucesor) VALUES ('" + source + "', '" + target + "');";      
		
		this.changes.add(query); 
		
	}

	public void createVertex(String name) throws SQLException {  //Agrego datos a la tabla temas
				
		//Si voy a crear un arco, ya tiene que estar creado el nodo verdad?, o se va a poner la posibilidad de crear un arco y si el nodo no existe se agrega?
		
		String query = "INSERT INTO temas(nombre_tema) VALUES ('" + name + "')" + ";" ;
		
		this.changes.add(query); 	
		
	}

	public void removeEdge(String source, String target) { //Eliminar un registro de la tabla correlatividades
		
		String query = "DELETE FROM correlatividades WHERE (antecesor = '" + source + "' AND sucesor = '" + target + "';";
		
		this.changes.add(query);
	}

	public void removeVertex(String name) { //Eliminar un registro de la tabla temas
	    
		//Si elimino un tema(nodo) que hacemos con el arco?, se borra o se pone a null el origen o destino respectivamente.
		
		String query = "DELETE FROM temas WHERE nombre_tema = '" + name + "';";
		
		this.changes.add(query);
	}
		
	public ResultSet getTablaTemas()
	{
		
		String query = "SELECT nombre_tema AS nombre_tema FROM temas;";
		return this.cn.executeQuery(query);
		
	}
	
	public ResultSet getTablaCorrelativas()
	{
		String query = "SELECT antecesor AS id_source, sucesor AS id_target FROM correlatividades;";
		return this.cn.executeQuery(query);
	}
	
	
	//Las eliminaciones pueden quedar para el siguiente sprint
	//Las modificaciones de los atributos quedaran para el siguiente sprint	
}
