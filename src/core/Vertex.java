package core;
import java.util.ArrayList;

public class Vertex {
	
	private String name;
	private ArrayList<Attribute> features;
	private static int id_them=0;;

		
	public Vertex(String name) { 
		this.name = name;
		id_them++;
		features = new ArrayList<Attribute>();
	}
	
	public int getid_them(){
		return id_them;
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

	public String getName() {
		return name;
	}	
	
	public void setName(String name){
		this.name = name;
	}
	
}