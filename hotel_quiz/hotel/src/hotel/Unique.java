package hotel;

public abstract class Unique {
    
    // A unique element is one with a globally unique identifier. The identifier
    // is a number that is allocated when the element is created by incrementing 
    // a counter. The counter is declared 'static' and is therefore shared between
    // all unique elements...

    private static int counter = 0;

    private int id = counter++;

    public int getId() {
	return id;
    }

}
