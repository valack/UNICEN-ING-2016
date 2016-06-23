package core.graphModel;

import java.util.ArrayList;

public class Edge {
	
	private ArrayList<Attribute> features;
	private Vertex source, target;

	
	public Edge (Vertex source, Vertex target){
		this.source = source;
		this.target = target;
		features = new ArrayList<Attribute>();
	}
	
	public void addFeature(Attribute a){ 
		this.features.add(a);
	}
	
	
	public void deleteFeature(Attribute a){
		this.features.remove(a);
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

	//metodo auxiliar para la clase Graph
	public void removerVertex(Vertex v) {
		if(v.getName().equals(source.getName()))
			source=new Vertex("");
		if(v.getName().equals(target.getName()))
			target=new Vertex("");		
	}

	//metodo auxiliar para la clase Graph
	public void changeVertex(Vertex v, ArrayList<Attribute> features2) {
		if(source.getName().equals(v.getName()))
			source.setFeatures(features2);
		if(target.getName().equals(v.getName()))
			target.setFeatures(features2);		
	}
	
	//metodo auxiliar para la clase Graph
	public boolean existInEdge(Vertex v) {
		return (v.getName().equals(source.getName())||(v.getName().equals(target.getName())));
	}
	
	//metodo auxiliar para la clase Graph
	public Vertex getVertex(Vertex v) {
		if(v.getName().equals(source.getName()))
			return source;
		if(v.getName().equals(target.getName()))
			return target;
		return null;
	}
	
}
