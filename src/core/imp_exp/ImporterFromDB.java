package core.imp_exp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Course;
import dataBase.*;

public class ImporterFromDB extends Importer{

	private String getThemeName (ResultSet rsCourse, int dbIDtheme)	{
		/**
		 * Retorno el nombre del curso a partir del ID de la tabla correlatividades.
		 * 
		 */
		try {
			while ( rsCourse.next() )	{
				if ( rsCourse.getInt("id_tema") == dbIDtheme )
					return rsCourse.getString("nombre_tema");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Course importCourse(Object source) throws IOException {
		/**
		 *  Obtengo el id Source e id Target de la table Correlatividades, 
		 *  para luego crear los nodos a partir del nombre de la tabla temas.
		 *   Se crea el Edge con los respectivos nodos y se agregan al grafo.
		 */

		ResultSet rsTheme  = ((QueryExecutor)source).getTablaTemas();
		ResultSet rsEdge   = ((QueryExecutor)source).getTablaCorrelativas();
		Course course = new Course();
		try	{
			while ( rsEdge.next() )	{	
				int idSource = rsEdge.getInt("id_source");	
				int idTarget = rsEdge.getInt("id_target");
				String sourceName = getThemeName(rsTheme, idSource);
				String targetName = getThemeName(rsTheme, idTarget);
				course.createCorrelative(sourceName, targetName, null, null, null);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return course;
	}


}
