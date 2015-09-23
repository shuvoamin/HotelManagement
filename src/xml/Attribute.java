package xml;

public class Attribute {
    
    // An XML element attribute...

    private String name;

    private String value;

    public Attribute(String name, String value) {
	super();
	this.name = name;
	this.value = value;
    }

    public String toString() {
	return name + "='" + value + "'";
    }

}
