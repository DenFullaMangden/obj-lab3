import java.awt.*;

public class Truck extends LandVehicle {

    public Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.stopEngine();
    }
}