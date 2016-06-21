import java.util.ArrayList;

public class Vertex {
	
	String name;
	ArrayList<Attribute> attributes;
		
	public Vertex(String name) {
		this.name=name;
		attributes = ArrayList<Attribute>();
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void addAttribute(Attribute a){
		this.attributes.add(a);
	}
	
	public void deleteAttribute(Attribute a){
		this.attributes.remove(a);
	}	
}
