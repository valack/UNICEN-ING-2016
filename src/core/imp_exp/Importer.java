package core.imp_exp;

import java.io.IOException;

import core.Course;

public abstract class Importer {

	public abstract Course importCourse(Object source) throws IOException; 
	
}
