package gui;

import java.io.IOException;

import core.Course;
import core.Exporter;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//		cargar
		//		guardar
		//		mostrar
		Course curso = new Course();
		curso.createCorrelative("OPD", "OPF", null, null, null);
		curso.createCorrelative("CM", "PMC", null, null, null);
		curso.createCorrelative("REQM", "RD", null, null, null);
		curso.createCorrelative("RD", "VAL", null, null, null);
		curso.createCorrelative("CM", "QA", null, null, null);
		Exporter test = new Exporter();
		test.export(curso);
		System.out.println("termine");
	}

}
