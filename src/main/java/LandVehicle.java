import java.awt.*;

public class LandVehicle extends Vehicle implements Transportable<Vehicle> {

    private boolean isBeingTransported;
    private Vehicle currentTransporter;

    public LandVehicle(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.stopEngine();
        this.isBeingTransported = false;
        this.currentTransporter = null;
    }

    @Override
    public boolean isBeingTransported() {
        return isBeingTransported;
    }

    @Override
    public void transportedBy(Vehicle vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Vehicle cannot be null");
        }
        if (this.isBeingTransported) {
            throw new IllegalStateException(
                    "Car is already being transported by " + currentTransporter);
        }

        this.currentTransporter = vehicle;
        this.isBeingTransported = true;
        this.stopEngine();
        this.setPosition(vehicle.getPosition());
    }

    @Override
    public void untransport() {
        if (!this.isBeingTransported) {
            throw new IllegalStateException("Car is not being transported");
        }

        if (currentTransporter != null) {
            this.setPosition(currentTransporter.getPosition());
        }

        this.currentTransporter = null;
        this.isBeingTransported = false;
    }

    @Override
    public Vehicle getCurrentTransport() {
        return currentTransporter;
    }

    @Override
    public void startEngine() {
        if (isBeingTransported) {
            throw new IllegalStateException(
                    "Cannot start engine while being transported by " + currentTransporter);
        }
        super.startEngine();
    }

    @Override
    public void gas(double amount) {
        if (isBeingTransported) {
            throw new IllegalStateException(
                    "Cannot gas while being transported by " + currentTransporter);
        }
        super.gas(amount);
    }

    @Override
    public void brake(double amount) {
        if (isBeingTransported) {
            throw new IllegalStateException(
                    "Cannot brake while being transported by " + currentTransporter);
        }
        super.brake(amount);
    }

    @Override
    public void move() {
        if (isBeingTransported) {
            throw new IllegalStateException(
                    "Cannot move while being transported by " + currentTransporter);
        }
        super.move();
    }

    @Override
    public void turnLeft() {
        if (isBeingTransported) {
            throw new IllegalStateException("Cannot turn while being transported");
        }
        super.turnLeft();
    }

    @Override
    public void turnRight() {
        if (isBeingTransported) {
            throw new IllegalStateException("Cannot turn while being transported");
        }
        super.turnRight();
    }

}