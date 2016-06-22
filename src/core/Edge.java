package core;

import java.util.ArrayList;

//import dataBase.DBManager;


public class Edge {
	
	private ArrayList<Attribute> features;
	private Vertex source, target;
//	private DBManager manager;
/*
 *Para mi alguna clase de afuera hace los llamados a la base de datos para llevar los cambios cuando
 *se cambia algo en memoria.
 * 
 */
	public Edge (Vertex source, Vertex target, ArrayList<Attribute> features/*, DBManager d*/){
		this.source = source;
		this.target = target;
		this.features = features;
//		this.manager = d;
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
	
//
//	public void deleteEdge (Vertex s, Vertex d){
//		//Que hago con los que paso, definir despues en la clase de arriba
//		source = null;
//		target = null;
//		manager.deleteEdge(source,target);
//	}
}
