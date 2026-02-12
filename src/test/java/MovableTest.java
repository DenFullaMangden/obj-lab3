import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovableTest {

    @Test
    void genericCarTest() {
        class GenericVehicle extends Vehicle {
            public GenericVehicle(int nrDoors, Color color, double enginePower, String modelName) {
                super(nrDoors, color, enginePower, modelName);
            }
        }
        GenericVehicle car = new GenericVehicle(4, Color.black, 100, "GenericCar");
        assertEquals(100 * 0.01, car.speedFactor());
    }

}
