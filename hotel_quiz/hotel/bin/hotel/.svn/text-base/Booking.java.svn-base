package hotel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;

import xml.XMLOutput;

public class Booking extends Unique {

    // A booking holds between a customer and a room. The booking
    // is created, then the customer arrives, the customer may then
    // use the facilities of the hotel before checking out and
    // paying the bill. The cost of the stay is calculated by
    // multiplying the cost of the room by the length of the stay
    // and adding on the cost of any extra facilities that have
    // been used.

    // The date formatter is used to create dates in the specified format...

    private static DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    static {
	dateFormatter.setTimeZone(TimeZone.getTimeZone("Europe/London"));
    }

    private Date dateBooked = null; // Set when the booking is created.

    private Date dateArrived = null; // Set when the customer checks in.

    private Date dateCheckedOut = null; // Set when the customer checks out.

    private boolean arrived = false; // True when the customer has arrived.

    private boolean paid = false; // True when the customer has paid.

    private Customer customer;

    private Room room;

    private Vector<AdditionalItem> costs = new Vector<AdditionalItem>();

    public Booking(Customer customer, Room room, String date) {
	super();
	this.customer = customer;
	this.room = room;
	try {
	    this.dateBooked = dateFormatter.parse(date);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
    }

    private double additionalCosts() {
	
	// Calculate the cost of all the facilities used in the hotel...
	double price = 0.0;
	for (AdditionalItem item : costs)
	    price = price + item.getCost();
	return price;
    }

    public void buyDrink(double cost) {
	costs.add(new Drink(cost));
    }

    public void buyMeal(double cost) {
	costs.add(new Meal(cost));
    }

    public boolean checkout(double money, String date) {
	
	// The supplied date will determine the cost of the room.
	// The method returns a boolean which determines whether 
	// the checkout was successful. To successfully checkout, 
	// the customer must supply sufficient funds to cover the
	// bill...
	
	try {
	    setDateCheckedOut(dateFormatter.parse(date));
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	if (money >= price())
	    setPaid(true);
	else
	    setPaid(false);
	return paid;
    }

    public int days() {
	
	// Calculate the length of the stay. The arrival check-in and
	// the check-out dates can be translated to times in milliseconds.
	// By subtracting the check-in date from the check0out date and
	// then translating from milliseconds to days we get the length
	// of the stay in days...
	
	long tNow = dateCheckedOut != null ? dateCheckedOut.getTime() : new Date().getTime();
	long tThen = arrived ? getDateArrived().getTime() : tNow;
	long diff = tNow - tThen;

	long secondInMillis = 1000;
	long minuteInMillis = secondInMillis * 60;
	long hourInMillis = minuteInMillis * 60;
	long dayInMillis = hourInMillis * 24;
	long yearInMillis = dayInMillis * 365;

	diff = diff % yearInMillis;
	long elapsedDays = diff / dayInMillis;

	return (int) elapsedDays;
    }

    public Vector<AdditionalItem> getCosts() {
	return costs;
    }

    public Customer getCustomer() {
	return customer;
    }

    public Date getDateArrived() {
	return dateArrived;
    }

    public Date getDateBooked() {
	return dateBooked;
    }

    public Date getDateCheckedOut() {
	return dateCheckedOut;
    }

    public Room getRoom() {
	return room;
    }

    public boolean isArrived() {
	return arrived;
    }

    public boolean isPaid() {
	return paid;
    }

    public double price() {
	
	// The total cost of the stay...
	
	return days() * room.getType().getPrice() + additionalCosts();
    }

    public void setArrived(boolean arrived, String date) {
	this.arrived = arrived;
	try {
	    setDateArrived(dateFormatter.parse(date));
	} catch (ParseException e) {
	    e.printStackTrace();
	}
    }

    public void setCosts(Vector<AdditionalItem> costs) {
	this.costs = costs;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public void setDateArrived(Date dateArrived) {
	this.dateArrived = dateArrived;
    }

    public void setDateBooked(Date dateBooked) {
	this.dateBooked = dateBooked;
    }

    public void setDateCheckedOut(Date dateCheckedOut) {
	this.dateCheckedOut = dateCheckedOut;
    }

    public void setPaid(boolean paid) {
	this.paid = paid;
    }

    public void setRoom(Room room) {
	this.room = room;
    }

    public void useSpa(double cost) {
	costs.add(new Spa(cost));
    }

    public void xml(XMLOutput out) {
	out.openElement("Booking");
	out.addAttribute("dateBooked", getDateBooked());
	out.addAttribute("dateArrived", getDateArrived());
	out.addAttribute("checkOut", getDateCheckedOut());
	out.addAttribute("customer", getCustomer().getId());
	out.addAttribute("room", getRoom().getId());
	out.addAttribute("cost", price() + "");
	for (AdditionalItem cost : costs)
	    cost.xml(out);
	out.closeElement();
    }

}
