package hotel;

import xml.XMLOutput;

public class Spa extends AdditionalItem {
    
    // Use of the Spa is extra in some hotels and free in others...

    public Spa(double cost) {
	super(cost);
    }

    public void xml(XMLOutput out) {
	out.openElement("Spa");
	out.addAttribute("cost", getCost());
	out.closeElement();
    }

}
