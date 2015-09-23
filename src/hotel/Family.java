package hotel;

import xml.XMLOutput;

public class Family extends RoomType {
    
    // A family room...

    public Family(double price) {
	super(price);
    }

    public void xml(XMLOutput out) {
	out.openElement("Family");
	out.addAttribute("price", getPrice());
	out.closeElement();
    }

}
