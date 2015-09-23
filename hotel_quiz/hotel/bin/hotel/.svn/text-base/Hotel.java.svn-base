package hotel;

import java.util.Vector;

import xml.XMLOutput;

public class Hotel extends Located {
    
    // A hotel has a unique identifier and a name and address. A hotel
    // contains rooms that can be booked by customers via the booking system.
    // A hotel is created and then populated by adding rooms. Each room
    // has a type that determines its cost on a daily basis.

    private Vector<Room> rooms = new Vector<Room>();

    public Hotel(String name, String address) {
	super(name, address);
    }

    public int addRoom(RoomType.Type type, int number, double price) {
	
	// Add a room by supplying the type of the room, the number of the
	// room and the cost...
	
	Room room;
	switch (type) {
	case Single:
	    room = new Room(new Single(price), number);
	    break;
	case Double:
	    room = new Room(new Double(price), number);
	    break;
	case Family:
	    room = new Room(new Family(price), number);
	    break;
	case Suite:
	    room = new Room(new Suite(price), number);
	    break;
	default:
	    throw new Error("Unknown type of room: " + type);
	}
	rooms.addElement(room);
	return room.getId();
    }

    public Room getRoom(int roomNumber) {
	
	// Get a room based on its number...
	
	for (Room room : rooms)
	    if (room.getNumber() == roomNumber)
		return room;
	throw new Error("Cannot find room: " + roomNumber);
    }

    public void xml(XMLOutput out) {
	out.openElement("Hotel");
	out.addAttribute("id", getId());
	out.addAttribute("name", getName());
	out.addAttribute("address", getAddress());
	for (Room room : rooms)
	    room.xml(out);
	out.closeElement();
    }

}
