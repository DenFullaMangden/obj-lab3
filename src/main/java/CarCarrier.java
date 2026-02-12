import java.awt.*;
import java.util.ArrayList;

public class CarCarrier extends Truck implements Storage<Car>, Transporter<Car> {

    private final int capacity;
    public boolean rampUp = true;
    private final ArrayList<Car> loadedCars;

    public CarCarrier(int capacity) {
        super(2, Color.blue, 150, "Car Carrier");
        this.capacity = capacity;
        this.loadedCars = new ArrayList<>();
        this.stopEngine();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isRampUp() {
        return rampUp;
    }

    public void switchRamp() {
        if (this.getCurrentSpeed() != 0) {
            throw new IllegalStateException("Cannot operate ramp while moving.");
        }
        this.rampUp = !this.rampUp;
    }

    @Override
    public void startEngine() {
        if (!this.rampUp) {
            throw new IllegalStateException("Cannot move with ramp down");
        }
        super.startEngine();
    }

    @Override
    public void gas(double amount) {
        if (!this.rampUp) {
            throw new IllegalStateException("Cannot move with ramp down");
        }
        super.gas(amount);
    }

    @Override
    public boolean isEmpty() {
        return this.loadedCars.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.loadedCars.size() == this.capacity;
    }

    public void load(Car car) {
        if (this.rampUp) {
            throw new IllegalStateException("Cannot load when ramp is up.");
        }
        if (isFull()) {
            throw new IllegalStateException("The car carrier is full.");
        }
        if (car.isBeingTransported()) {
            throw new IllegalStateException("Car is already being transported.");
        }
        loadedCars.add(car);
        car.transportedBy(this);
    }

    @Override
    public Car unload() {
        if (this.rampUp) {
            throw new IllegalStateException("Ramp must be down to unload car.");
        }
        if (isEmpty()) {
            throw new IllegalStateException("No cars to unload.");
        }

        Car car = loadedCars.remove(loadedCars.size() - 1);
        car.untransport();
        return car;
    }

    @Override
    public void moveLoaded() {
        for (Car loadedCar : this.loadedCars) {
            loadedCar.setPosition(this.getPosition());
        }
    }

    @Override
    public void move() {
        super.move();
        this.moveLoaded();
    }

}