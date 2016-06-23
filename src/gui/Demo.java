package gui;

import java.io.IOException;

import core.Course;
import core.Exporter;
import dataBase.*;

public class Demo {

	public static void main(String[] args) throws IOException {
		/*
		 * Creacion del grafo en memoria
		 */
		ConnectionPostgresql connection = new ConnectionPostgresql("ing2016");
		Course curso = new Course(connection);
		curso.createCorrelative("OPD", "OPF", null, null, null);
		curso.createCorrelative("CM", "PMC", null, null, null);
		curso.createCorrelative("REQM", "RD", null, null, null);
		curso.createCorrelative("RD", "VAL", null, null, null);
		curso.createCorrelative("CM", "QA", null, null, null);
		
		/*
		 * Guardar grafo en la base de datos
		 */
		
		/*Importa de la base de datos a memoria
		 * 
		 */
		
		/*
		 * Exporta de memoria a input de graphviz
		 */
		Exporter test = new Exporter();
		test.export(curso);
		System.out.println("termine");

		/*
		 * GRAPHVIZ a partir de la exportacion
		 */
		try {
			//Aca pones la dirección de donde esta instalado Graphviz->bin->dot.exe      
			String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
			//Aca pones el archivo de entrada(que indica que nodos hay y los arcos entre los nodos)
			String fileInputPath = "curso.txt";
			//Aca pones donde queres que se guarde el grafo que se origina
			String fileOutputPath = "grafo1.jpg";

			String tParam = "-Tjpg";
			String tOParam = "-o";

			String[] cmd = new String[5];
			cmd[0] = dotPath;
			cmd[1] = tParam;
			cmd[2] = fileInputPath;
			cmd[3] = tOParam;
			cmd[4] = fileOutputPath;

			Runtime rt = Runtime.getRuntime();

			rt.exec( cmd );

		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
