package core.graphModel;

public class Attribute {
	
	private String feature;
	private Object value;

	public Attribute(String feature, Object value){
		this.feature = feature;
		this.value = value;
	}

	public String getFeature(){
		return feature;
	}

	public Object getValue(){
		return value;
	}
	
}

