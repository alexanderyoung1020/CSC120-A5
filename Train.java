/**
The Train class represents a train that consists of an engine and a list of cars.
Each car has a maximum passenger capacity and the train has a total maximum capacity
based on the sum of each car's maximum passenger capacity. The Train class also provides
methods for accessing and manipulating its engine and cars.
*/
import java.util.ArrayList;
public class Train {
    private final Engine engine;
    private ArrayList<Car> cars;
/**
 * Constructs a new Train object with a specified fuel type, fuel capacity, number of cars,
 * and passenger capacity.
 *
 * @param fuelType the type of fuel used by the train's engine
 * @param fuelCapacity the maximum amount of fuel that the engine can hold
 * @param nCars the number of cars that the train will have
 * @param passengerCapacity the maximum number of passengers that each car can hold
 */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        engine = new Engine(FuelType.STEAM, 100, 200);
        cars = new ArrayList<Car>();

        for (int i = 0; i < nCars; i++) {
            Car newCar = new Car(passengerCapacity);
            cars.add(newCar);
        }
    }
/**
 * Returns the engine of the train.
 *
 * @return the engine of the train
 */
    public Engine getEngine() {
        return engine;
    }
/**
 * Returns the car at the specified index in the list of cars.
 *
 * @param i the index of the car to return
 * @return the car at the specified index
 */
    public Car getCar(int i) {
        return cars.get(i);
    }
/**
 * Returns the total maximum capacity of the train, which is the sum of each car's
 * maximum passenger capacity.
 *
 * @return the total maximum capacity of the train
 */
    public int getMaxCapacity() {
        int maxCapacity = 0;
        for (Car car : cars) {
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }
/**
 * Returns the total number of remaining seats on the train, which is the sum of
 * the number of remaining seats on each car.
 *
 * @return the total number of remaining seats on the train
 */
    public int seatsRemaining() {
        int totalRemaining = 0;
        for (Car car : cars) {
            totalRemaining += car.seatsRemaining();
        }
        return totalRemaining;
    }

    public void printManifest() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + i + ":");
            cars.get(i).printManifest();
            System.out.println();
        }
    }
    
/**
 * Prints the manifest for the train, which consists of the list of passengers on each car.
 */
    public static void main(String[] args) {
        Train train = new Train(FuelType.STEAM, 100, 4, 10);
        Passenger alice = new Passenger("Alice");
        Passenger bob = new Passenger("Bob");
        Passenger charlie = new Passenger("Charlie");
        alice.boardCar(train.getCar(0));
        bob.boardCar(train.getCar(1));
        charlie.boardCar(train.getCar(2));
        train.printManifest();
        alice.getOffCar(train.getCar(0));
        bob.boardCar(train.getCar(0));
        train.printManifest();
    }
}

