package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Importer {
	
	private Graph themes;
	
	public Importer() {
		this.themes = new Graph();
	}
	
	public Graph getThemes() {
		return themes;
	}
	
	public void readFile(String address) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(address));
		try {
			Edge edge;
			Vertex v1,v2;
			String aux, separator="->";
			int posseparator;
			
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
	        //Avanza el header
	    	for(int i=0; i<7;i++)
		    	line = br.readLine();
	    	//Lee el resto de las lineas
		    while (line != null) {
		    	//Lee la linea, si corresponde a un arco lo agrega al grafo
		        aux=sb.append(line).toString().trim();
		        if(aux.contains(separator)){
		        	posseparator=aux.indexOf("->");
		        	v1 = new Vertex(aux.substring(0,posseparator));
		        	v2 = new Vertex(aux.substring((posseparator+3)));
		        	edge = new Edge(v1,v2);
		        	themes.addEdge(edge);
		        }
		        sb.delete(0, sb.length());
		    	line = br.readLine();
		    }
		} finally {
		    br.close();
		}
	}

		public Graph importGraphFromDB (ResultSet rsCourse, ResultSet rsEdge)	{
		/**
		 *  Obtengo el id Source e id Target de la table Correlatividades, 
		 *  para luego crear los nodos a partir del nombre de la tabla temas.
		 *   Se crea el Edge con los respectivos nodos y se agregan al grafo.
		 */
		
		Graph auxGraph = new Graph();
		try	{
			while ( rsEdge.next() )	{	
				int idSource = rsEdge.getInt("id_source");	
				int idTarget = rsEdge.getInt("id_target");
				
				Vertex vertexSource = this.getCourse(rsCourse, idSource);
				Vertex vertexTarget = this.getCourse(rsCourse, idTarget);
				
				Edge edgeNew = new Edge(vertexSource, vertexTarget);
				
				auxGraph.addEdge(edgeNew);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return auxGraph;
	}

	public Vertex getCourse (ResultSet rsCourse, int node)	{
		/**
		 * Retorno el nombre del curso a partir del ID de la tabla correlatividades.
		 * 
		 */
		try {
			while ( rsCourse.next() )	{
				if ( rsCourse.getInt("id_tema") == node )
					return ( new Vertex(rsCourse.getString("nombre_tema")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
