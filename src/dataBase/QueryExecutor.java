package dataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryExecutor {

	
	private ConnectionPostgresql connection;

	
	
	public QueryExecutor(ConnectionPostgresql connection) {
		super();
		this.connection = connection;
	}

	public ResultSet getTablaTemas()
	{
		
		String query = "SELECT id_tema AS id_tema, nombre_tema AS nombre_tema FROM temas;";
		return this.connection.executeQuery(query);
		
	}
	
	public ResultSet getTablaCorrelativas()
	{
		String query = "SELECT antecesor AS id_source, sucesor AS id_target FROM correlatividades;";
		return this.connection.executeQuery(query);
	}
	
	public ResultSet executeChanges(ArrayList<String> querys){
		String megaQuery = "";
		for (String s : querys) {
			megaQuery.concat(s + "\n");
		}
		return connection.executeQuery(megaQuery);
	}
	
}
