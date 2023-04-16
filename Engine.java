/*
 * The Engine class represents a vehicle engine that runs on a specific type of fuel.
 * It has a current fuel level, maximum fuel level, and provides methods for refueling and running the engine.
 */
public class Engine {
        private FuelType fuelType;
        private double currentFuelLevel;
        private double maxFuelLevel;
    /**
    *Constructs an Engine object with a given fuel type, current fuel level, and maximum fuel level.
    *@param fuelType the type of fuel that the engine uses
    *@param currentFuelLevel the current level of fuel in the engine
    *@param maxFuelLevel the maximum level of fuel that the engine can hold
    */
    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
        }
    /**
    Returns the type of fuel that the engine uses.
    @return the fuel type of the engine
    */
    public FuelType getFuelType() {
        return fuelType;
        }
    /**
    Returns the current level of fuel in the engine.
    @return the current fuel level of the engine
    */
    public double getCurrentFuelLevel() {
        return currentFuelLevel;
        }
    
    public double getMaxFuelLevel() {
        return maxFuelLevel;
        }
    /**
    Returns the maximum level of fuel that the engine can hold.
    @return the maximum fuel level of the engine
    */
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
        System.out.println("Fuel level is at maximum: " + maxFuelLevel);
        }
    /**
    Runs the engine and decreases the current fuel level by 1 unit.
    If the current fuel level is 0, an exception is thrown.
    @throws RuntimeException if the engine is out of fuel
    */
    public void go() {
        if (currentFuelLevel > 0) {
            currentFuelLevel -= 1;
            System.out.println("Remaining fuel level: " + currentFuelLevel);
            } else {
            throw new RuntimeException("Out of fuel!");
            }
        }
        public static void main(String[] args) {
            Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 150.0);
            try {
                while (true) {
                    myEngine.go();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage()); // Out of fuel
            }
            myEngine.refuel();
        }
    }
    