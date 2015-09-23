package hotel;

import xml.XMLOutput;

public class Suite extends RoomType {

    public Suite(double price) {
	super(price);
    }

    public void xml(XMLOutput out) {
	out.openElement("Suite");
	out.addAttribute("price", getPrice());
	out.closeElement();
    }

}
