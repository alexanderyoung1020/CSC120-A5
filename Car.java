/**
The Car class represents a vehicle that can carry passengers.
It has a maximum capacity for passengers, and keeps track of the passengers currently on board.
Passengers can be added or removed from the car, and a manifest of current passengers can be printed.
*/
import java.util.ArrayList;
public class Car {

    private ArrayList<Passenger> passengers;
    private int maxCapacity;
    /**
    * Constructs a Car object with a given maximum capacity for passengers.
    * @param maxCapacity the maximum number of passengers the car can carry.
    */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<>(maxCapacity);
    }
    /**
    * Returns the maximum capacity of the car.
    * @return the maximum number of passengers the car can carry.
    */
    public int getCapacity() {
        return this.maxCapacity;
    }
    /**
    * Returns the number of seats remaining in the car.
    * @return the number of empty seats in the car.
    */
    public int seatsRemaining() {
        return this.maxCapacity - this.passengers.size();
    }
    /**
    * Adds a passenger to the car, if there is space available.
    * @param p the passenger to add to the car.
    * @throws RuntimeException if the car is already at maximum capacity.
    */
    public void addPassenger(Passenger p) {
        if (seatsRemaining() == 0) {
            throw new RuntimeException("Car is full!");
        }
        this.passengers.add(p);
    }
    /**
    * Removes a passenger from the car, if they are currently on board.
    * @param p the passenger to remove from the car.
    * @throws RuntimeException if the passenger is not currently on board the car.
    */
    public void removePassenger(Passenger p) {
        if (!this.passengers.contains(p)) {
            throw new RuntimeException("Passenger is not on this car!");
        }
        this.passengers.remove(p);
    }
    /**
    * Prints a manifest of the passengers currently on board the car.
    * If there are no passengers on board, prints a message indicating the car is empty.
    */
    public void printManifest() {
        if (this.passengers.size() == 0) {
            System.out.println("This car is EMPTY.");
            return;
        }
        System.out.println("Passengers on board:");
        for (Passenger p : this.passengers) {
            System.out.println(p.toString());
        }
    }
}


