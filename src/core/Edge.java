package core;

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
	
}
