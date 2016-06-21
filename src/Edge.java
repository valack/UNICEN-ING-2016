import java.util.ArrayList;
import java.util.Hashtable;

public class Edge {
	
	private ArrayList<Attribute> features;
	private Vertex source, destination;
	private DBManager manager;
	
	public Edge (Vertex n1, Vertex n2, ArrayList<Attribute> feat, DBManager d){
		this.source = n1;
		this.destination = n2;
		this.features = feat;
		this.manager = d;
		d.createEdge(home,destination,feat);
	}
	
	public void changeSource (Vertex s){
		this.source = s;
		//Tengo que pasarle todos.
		manager.changeSource(source, destination);
	}
	
	public void changeDestination (Vertex d){
		this.destination = d;
		//Tengo que pasarle todos.
		manager.changeDestination(source,destination);
	}
	
	public void changeFeatures (ArrayList<Attribute> f) {
		//Paso source, destination y las features.
		this.features = f;
		manager.changeFeatures(source,destination,features);
	}
	
	public void deleteEdge (Vertex s, Vertex d {
		//Que hago con los que paso, definir despues en la clase de arriba
		source = null;
		destination = null;
		manager.deleteEdge(source,destination);
	}
}
