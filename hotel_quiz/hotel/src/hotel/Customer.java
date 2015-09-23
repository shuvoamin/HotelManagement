package hotel;

import xml.XMLOutput;

public class Customer extends Located {
    
    // A customer registers with the booking system and is allocated
    // a unique identifier. The identifier is used to reference the
    // customer within the booking system. The customer name and
    // address is retained for contact and for chasing unpaid bills.

    public Customer(String name, String address) {
	super(name, address);
    }

    public void xml(XMLOutput out) {
	out.openElement("Customer");
	out.addAttribute("id", getId());
	out.addAttribute("name", getName());
	out.addAttribute("address", getAddress());
	out.closeElement();
    }

}
