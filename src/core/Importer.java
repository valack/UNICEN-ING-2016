package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import dataBase.DBManager;

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
			String aux;
			int separator;
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
	        //Avanza el header
	    	for(int i=0; i<5;i++)
		    	line = br.readLine();
	    	//Lee el resto de las lineas
		    while (line != null) {
		    	//Lee la linea, si corresponde a un arco lo agrega al grafo
		        aux=sb.append(line).toString().trim();
		        if(Pattern.matches("*->*", aux)){
		        	separator=aux.indexOf("->");
		        	v1 = new Vertex(aux.substring(0,separator));
		        	v2 = new Vertex(aux.substring((separator+2)));
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
}
