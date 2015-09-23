package hotel;

import java.util.Vector;

import xml.XMLOutput;

public class BookingSystem {
    
    // A booking system manages all of the information about
    // hotels, customers and room bookings. The BookingSystem
    // API is used in terms of numeric identifiers for customers,
    // hotels, bookings etc. A booking system can be translated
    // into an XML representation to view the current state.

    private Vector<Customer> customers = new Vector<Customer>();

    private Vector<Hotel> hotels = new Vector<Hotel>();
    
    // Current bookings are those that have been made, but whose
    // customers have yet to check-in and pay...

    private Vector<Booking> current = new Vector<Booking>(); 
    
    // A paid booking is moved from the current bookings to the
    // history so that the booking system knows about all past
    // bookings...

    private Vector<Booking> history = new Vector<Booking>();

    public Vector<Booking> getCurrent() {
	return current;
    }

    public Vector<Customer> getCustomers() {
	return customers;
    }

    public Vector<Booking> getHistory() {
	return history;
    }

    public Vector<Hotel> getHotels() {
	return hotels;
    }

    public void setCurrent(Vector<Booking> current) {
	this.current = current;
    }

    public void setCustomers(Vector<Customer> customers) {
	this.customers = customers;
    }

    public void setHistory(Vector<Booking> history) {
	this.history = history;
    }

    public void setHotels(Vector<Hotel> hotels) {
	this.hotels = hotels;
    }

    public int addHotel(String name, String address) {
	Hotel hotel = new Hotel(name, address);
	hotels.addElement(hotel);
	return hotel.getId();
    }

    public int addRoom(int hotelId, RoomType.Type type, int number, double price) {
	return getHotel(hotelId).addRoom(type, number, price);
    }

    private Hotel getHotel(int hotelId) {
	for (Hotel hotel : hotels)
	    if (hotel.getId() == hotelId)
		return hotel;
	throw new Error("No hotel: " + hotelId);
    }

    public int registerCustomer(String name, String address) {
	Customer customer = new Customer(name, address);
	customers.addElement(customer);
	return customer.getId();
    }

    public int book(int customerId, int hotelId, int roomNumber, String date) {
	Customer customer = getCustomer(customerId);
	Hotel hotel = getHotel(hotelId);
	Room room = hotel.getRoom(roomNumber);
	return addBooking(customer, room, date);
    }

    private int addBooking(Customer customer, Room room, String date) {
	Booking b = new Booking(customer, room, date);
	current.addElement(b);
	return b.getId();
    }

    private Customer getCustomer(int customerId) {
	for (Customer customer : customers)
	    if (customer.getId() == customerId)
		return customer;
	throw new Error("Cannot find customer: " + customerId);
    }

    public void xml(XMLOutput out) {
	out.openElement("System");
	for (Customer customer : customers)
	    customer.xml(out);
	for (Hotel hotel : hotels)
	    hotel.xml(out);
	out.openElement("Current");
	for (Booking booking : current)
	    booking.xml(out);
	out.closeElement();
	out.openElement("History");
	for (Booking booking : history)
	    booking.xml(out);
	out.closeElement();
	out.closeElement();
    }

    public void arrive(int bookingId, String date) {
	Booking b = getBooking(bookingId);
	b.setArrived(true, date);
    }

    private Booking getBooking(int bookingId) {
	for (Booking b : current)
	    if (b.getId() == bookingId)
		return b;
	throw new Error("No booking with id " + bookingId);
    }

    public void useSpa(int bookingId, double cost) {
	Booking b = getBooking(bookingId);
	b.useSpa(cost);

    }

    public void buyDrink(int bookingId, double cost) {
	Booking b = getBooking(bookingId);
	b.buyDrink(cost);
    }

    public void buyMeal(int bookingId, double cost) {
	Booking b = getBooking(bookingId);
	b.buyMeal(cost);
    }

    public void checkout(int bookingId, double money, String date) {
	Booking b = getBooking(bookingId);
	boolean paid = b.checkout(money, date);
	if (paid)
	    moveToHistory(b);
	else
	    System.out.println("You offered £" + money + " but the room costs £" + b.price());
    }

    private void moveToHistory(Booking b) {
	current.remove(b);
	history.add(b);
    }

}
