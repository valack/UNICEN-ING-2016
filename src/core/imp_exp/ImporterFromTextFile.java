package core.imp_exp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import core.Course;

public class ImporterFromTextFile extends Importer {



	//	@Override
	//	public Course importCourse(Object source) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

	@Override
	public Course importCourse(Object source) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader((String) source));
		Course course = new Course();
		try {
			String theme, correlativeTheme, aux, separator="->";
			int indexOfseparator;

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			//Lee el resto de las lineas
			while (line != null) {
				//Lee la linea, si corresponde a un arco lo agrega al grafo
				aux = sb.append(line).toString().trim();
				if (aux.contains(separator)){
					indexOfseparator=aux.indexOf("->");
					theme = aux.substring(0,indexOfseparator);
					correlativeTheme = aux.substring((indexOfseparator + separator.length() + 1));
					course.createCorrelative(theme, correlativeTheme, null, null, null);
				}
				sb.delete(0, sb.length());
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return course;
	}

}
