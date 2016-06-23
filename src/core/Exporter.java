package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Exporta un grafo de temas en memoria a un archivo de texto en el formato que acepta Graphviz como input
 * @author Team 2.1
 *
 */

public class Exporter {
	
	private FileWriter file;
	private BufferedWriter writer;
	
	
	public Exporter() throws IOException {
		file = new FileWriter("curso.txt");
		writer = new BufferedWriter(file);
	}

	private void insertHeader() throws IOException{
		writer.write("digraph G"); 						writer.newLine();
		writer.write("{node [shape=square];"); 			writer.newLine();
		writer.write("node [style=filled];"); 			writer.newLine();
		writer.write("node [fillcolor=\"#EEEEEE\"];"); 	writer.newLine();
		writer.write("node [color=\"#EEEEEE\"];"); 		writer.newLine();
		writer.write("edge [color=\"#31CEF0\"];"); 		writer.newLine();
	}
	
	private void insertFooter() throws IOException{
		writer.write("rankdir=LR;}");
	}
	

	private void parseGraph(Course themesGraph) throws IOException {
		for (Edge edge : themesGraph.getCorrelative()) {
			writer.write(edge.getSource().getName()  +  " -> "  +  edge.getTarget().getName());
			writer.newLine();
		}
	}
	
	public void export(Course themesGraph) throws IOException{
		insertHeader();
		parseGraph(themesGraph);
		insertFooter();
		writer.close();
	}

}