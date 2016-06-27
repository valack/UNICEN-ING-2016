package core.imp_exp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Course;
import dataBase.*;

public class ImporterFromDB extends Importer{

	@Override
	public Course importCourse(Object source) throws IOException {
		/**
		 *  Obtengo el id Source e id Target de la table Correlatividades, 
		 *  para luego crear los nodos a partir del nombre de la tabla temas.
		 *   Se crea el Edge con los respectivos nodos y se agregan al grafo.
		 */

		ResultSet rsEdge   = ((DBManager)source).getTablaCorrelativas();
		Course course = new Course((DBManager) source);
		
		try	{
			
			while ( rsEdge.next() )	{	
				
				String idSource = rsEdge.getString("id_source");	
				System.out.println(idSource);
				String idTarget = rsEdge.getString("id_target");
				System.out.println(idTarget);
				course.createCorrelative(idSource, idTarget, null, null, null);
			}
		} catch (Exception e) {
			System.out.println("No hay datos en la base");
		}	
		return course;
	}


}
