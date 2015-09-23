package xml;

import java.util.Stack;

public class XMLOutput {
    
    // An XML output element is used to create an XML representation of data.

    private Stack<Element> elements = new Stack<Element>();

    public void openElement(String tag) {
	
	// Start a new XML element by calling this method...
	
	elements.push(new Element(tag));
    }

    public Element closeElement() {
	
	// The most recently open element is closed. All intermediate
	// open elements are added as children to the element being closed.
	// The element is then marked as being closed...
	
	if (elements.peek().isOpen()) {
	    elements.peek().setOpen(false);
	    return elements.peek();
	} else {
	    Element element = elements.pop();
	    Element parent = closeElement();
	    parent.addChild(element);
	    return parent;
	}
    }

    public void addAttribute(String name, Object value) {
	
	// Add an attribute to the most recently opened element...
	
	elements.peek().addAttribute(name, value == null ? "" : value.toString());
    }

    public String toString() {
	return elements.peek().toString(0);
    }

}
