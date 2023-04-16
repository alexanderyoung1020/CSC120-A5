/**
Represents a passenger with a name who can board and get off a car.
*/
public class Passenger {
    private String name;
/**
Creates a new passenger with the given name.
@param name the name of the passenger.
*/
    public Passenger(String name) {
        this.name = name;
    }
/**
Returns the name of the passenger.
@return the name of the passenger.
*/
    public String getName() {
        return name;
    }
/**
Boards the given car by attempting to add this passenger to its passenger list.
If the car is already full, prints an error message.
@param c the car to board.
*/
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
            System.out.println(name + " has boarded the car.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
/**
Gets off the given car by attempting to remove this passenger from its passenger list.
If the passenger is not on the car, prints an error message.
@param c the car to get off.
*/
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
            System.out.println(name + " has gotten off the car.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
/**
Returns the name of the passenger as a string.
@return the name of the passenger.
*/
    public String toString() {
        return name;
    }
    
}

