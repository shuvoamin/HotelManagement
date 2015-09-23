package hotel;

import xml.XMLOutput;

public abstract class RoomType {
    
    // The type of a room determines its cost. There are standard
    // room types that are defined as an enumerated type...

    public enum Type {
	Single, Double, Family, Suite
    };

    private double price;

    public RoomType(double price) {
	super();
	this.price = price;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public abstract void xml(XMLOutput out);

}
