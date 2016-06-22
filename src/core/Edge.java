package core;
import java.util.ArrayList;
import java.util.Hashtable;

import dataBase.DBManager;

public class Edge {
	
	private ArrayList<Attribute> features;
	private Vertex source, target;
	private DBManager manager;
	
	public Edge (Vertex n1, Vertex n2, ArrayList<Attribute> feat, DBManager d){
		this.source = n1;
		this.target = n2;
		this.features = feat;
		this.manager = d;
		manager.createEdge(source, target, feat);
	}
	
	public void changeSource (Vertex s){
		this.source = s;
		//Tengo que pasarle todos.
		manager.changeSource(source, target);
	}
	
	public ArrayList<Attribute> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<Attribute> features) {
		this.features = features;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getTarget() {
		return target;
	}

	public void settarget(Vertex target) {
		this.target = target;
	}

	public void changetarget (Vertex d){
		this.target = d;
		//Tengo que pasarle todos.
		manager.changetarget(source,target);
	}
	
	public void changeFeatures (ArrayList<Attribute> f) {
		//Paso source, target y las features.
		this.features = f;
		manager.changeFeatures(source,target,features);
	}
	
	public void deleteEdge (Vertex s, Vertex d {
		//Que hago con los que paso, definir despues en la clase de arriba
		source = null;
		target = null;
		manager.deleteEdge(source,target);
	}
}
