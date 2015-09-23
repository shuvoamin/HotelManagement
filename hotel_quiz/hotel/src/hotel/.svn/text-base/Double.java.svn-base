package hotel;

import xml.XMLOutput;

public class Double extends RoomType {
    
    // A double room...

    public Double(double price) {
	super(price);
    }

    public void xml(XMLOutput out) {
	out.openElement("Double");
	out.addAttribute("price", getPrice());
	out.closeElement();
    }

}
