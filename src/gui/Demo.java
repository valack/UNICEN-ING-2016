package gui;

import java.io.IOException;

import core.*;
import core.imp_exp.Exporter;
import core.imp_exp.ImporterFromDB;
import core.imp_exp.ImporterFromTextFile;
import dataBase.*;

public class Demo {

	public static void main(String[] args) throws IOException {
		
		/* Conecto la base de datos */
		
		ConnectionPostgresql connection = new ConnectionPostgresql("ing123");
		
		connection.connection();
		
		/* Administrador de la base de datos*/
		
		DBManager dbManager = new DBManager(connection);	
		
		dbManager.cleanDB();
		
		/* Creacion del curso 
		/* Creacion del grafo en memoria */
		
		Course curso = new Course(dbManager);
		curso.createCorrelative("RD", "REQM", null, null, null);
		curso.createCorrelative("RD", "VAL", null, null, null);
		curso.createCorrelative("RD", "TS", null, null, null);
		curso.createCorrelative("TS", "VER", null, null, null);
		curso.createCorrelative("PP", "PMC", null, null, null);
		
		
		/*
		 * Guardar grafo en la base de datos
		 */
		
		dbManager.saveBD();
		
		/* Importa de la base de datos a memoria */
		
//		ImporterFromDB importer = new ImporterFromDB();
//		Course cursoDB = importer.importCourse(dbManager);
//		cursoDB.showCorrelative();
//		cursoDB.showThemes();
		
		
		
//		/*
//		 * Exporta de memoria a input de graphviz
//		 */
		Exporter test = new Exporter();
		test.export(curso);
		System.out.println("termine");

//		/*
//		 * GRAPHVIZ a partir de la exportacion
//		 */
//		try {
//			//Aca pones la dirección de donde esta instalado Graphviz->bin->dot.exe      
//			String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
//			//Aca pones el archivo de entrada(que indica que nodos hay y los arcos entre los nodos)
//			String fileInputPath = "curso.txt";
//			//Aca pones donde queres que se guarde el grafo que se origina
//			String fileOutputPath = "grafo1.jpg";
//
//			String tParam = "-Tjpg";
//			String tOParam = "-o";
//
//			String[] cmd = new String[5];
//			cmd[0] = dotPath;
//			cmd[1] = tParam;
//			cmd[2] = fileInputPath;
//			cmd[3] = tOParam;
//			cmd[4] = fileOutputPath;
//
//			Runtime rt = Runtime.getRuntime();
//
//			rt.exec( cmd );
//
//		} 
//		catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		ImporterFromTextFile imp = new ImporterFromTextFile(dbManager);
//		Course importedCourse = imp.importCourse("curso.txt");
//		importedCourse.showThemes();
//		importedCourse.showCorrelative();
	}
}
