package hotel;

import xml.XMLOutput;

public class Single extends RoomType {
    
    // A single room...

    public Single(double price) {
	super(price);
    }

    public void xml(XMLOutput out) {
	out.openElement("Single");
	out.addAttribute("price", getPrice());
	out.closeElement();
    }

}
