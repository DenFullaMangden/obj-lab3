import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

class VehicleTest {

    @Test
    void gettersTest() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
        saab.setColor(Color.white);
        assertEquals(Color.white, saab.getColor());
        assertEquals(125, saab.getEnginePower());
        assertEquals("Saab 95", saab.getModelName());
        assertEquals(0, saab.getCurrentSpeed());
        assertEquals( new Point2D.Double(), saab.getPosition());
    }

    @Test
    void brakeGasTest() {
        Saab95 saab = new Saab95();
        saab.brake(1.0);
        assertEquals(0.0, saab.getCurrentSpeed());
        saab.startEngine();
        saab.brake(2);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.brake(-2);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.gas(2);
        assertEquals(0.1, saab.getCurrentSpeed());
        saab.gas(-1);
        assertEquals(0.1, saab.getCurrentSpeed());
    }


}