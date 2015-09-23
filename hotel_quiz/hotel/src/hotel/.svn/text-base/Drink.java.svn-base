package hotel;

import xml.XMLOutput;

public class Drink extends AdditionalItem {
    
    // A drink ordered from the bar or room-service...

    public Drink(double cost) {
	super(cost);
    }

    public void xml(XMLOutput out) {
	out.openElement("Drink");
	out.addAttribute("cost", getCost());
	out.closeElement();
    }

}
