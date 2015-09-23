package hotel;

import xml.XMLOutput;

public class Meal extends AdditionalItem {
    
    // A meal bought in the hotel restaurant or via room service...

    public Meal(double cost) {
	super(cost);
    }

    public void xml(XMLOutput out) {
	out.openElement("Meal");
	out.addAttribute("cost", getCost());
	out.closeElement();
    }

}
