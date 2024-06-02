abstract class vehicle {
    protected String make;
    protected String model;
    protected int year;
    
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public vehicle(String make, String model, int year) {
    }


    public abstract double calculateFuelEfficiency();
}

class Car extends vehicle {
    private double milesDriven;
    private double fuelConsumed; 

    public Car(String make, String model, int year, double milesDriven, double fuelConsumed) {
        super(make, model, year);
        this.milesDriven = milesDriven;
        this.fuelConsumed = fuelConsumed;
    }

 
    @Override
    public double calculateFuelEfficiency() {
        return milesDriven / fuelConsumed;
    }
}

class Truck extends vehicle {
    private double milesDriven;
    private double fuelConsumed; 
    private double cargoWeight; 

  
    public Truck(String make, String model, int year, double milesDriven, double fuelConsumed, double cargoWeight) {
        super(make, model, year);
        this.milesDriven = milesDriven;
        this.fuelConsumed = fuelConsumed;
        this.cargoWeight = cargoWeight;
    }
    
    @Override
    public double calculateFuelEfficiency() {
        return milesDriven / (fuelConsumed + (cargoWeight * 0.5));
    }
}