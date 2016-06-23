package core;

import java.io.IOException;

public class mainDePrueba {
	public static void main(String [ ] args) throws IOException
	{
		Importer imp = new Importer();
		imp.readFile("auto.txt");
		imp.getThemes().showEdges();
	}
}
