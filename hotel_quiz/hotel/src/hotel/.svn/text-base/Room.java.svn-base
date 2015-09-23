package hotel;

import xml.XMLOutput;

public class Room extends Unique {
    
    // A room has a unique identifier (globally across the booking system)
    // and a number which is unique across the hotel containing the room.
    // The type of the room determines its cost on a daily basis.

    private RoomType type;

    private int number;

    public Room(RoomType type, int number) {
	super();
	this.type = type;
	this.number = number;
    }

    public int getNumber() {
	return number;
    }

    public RoomType getType() {
	return type;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public void setType(RoomType type) {
	this.type = type;
    }

    public void xml(XMLOutput out) {
	out.openElement("Room");
	out.addAttribute("id", getId());
	out.addAttribute("number", getNumber());
	type.xml(out);
	out.closeElement();
    }

}
