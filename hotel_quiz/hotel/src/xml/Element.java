package xml;

import java.util.Vector;

public class Element {
    
    // An XML element consists of a tag, some attributes and some child
    // elements. An element is marked as being open when it is created.
    // The marking scheme is used to work out which child elements to 
    // add (see closeELement in XMLOutput).

    private String tag;

    private Vector<Attribute> attributes = new Vector<Attribute>();

    private Vector<Element> children = new Vector<Element>();

    private boolean open = true;

    public boolean isOpen() {
	return open;
    }

    public void setOpen(boolean open) {
	this.open = open;
    }

    public Element(String tag) {
	super();
	this.tag = tag;
    }

    public void addChild(Element element) {
	children.add(element);
    }

    public void addAttribute(String name, String value) {
	attributes.add(new Attribute(name, value));
    }

    public String toString(int indent) {
	String s = "<" + tag;
	for (Attribute a : attributes) {
	    s = s + " ";
	    s = s + a.toString();
	}
	if (children.isEmpty())
	    return s + "/>";
	else {
	    s = s + ">";
	    s = s + newline(indent + 2);
	    for (Element e : children) {
		s = s + e.toString(indent + 2);
		if (children.lastElement() != e)
		    s = s + newline(indent + 2);
	    }
	    s = s + newline(indent);
	    return s + "</" + tag + ">";
	}
    }

    private String newline(int indent) {
	String s = "\n";
	for (int i = 0; i < indent; i++)
	    s = s + " ";
	return s;
    }

}
