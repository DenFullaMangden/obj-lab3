import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.geom.Point2D;

class TruckTest {

    @Test
    void gettersTest() {
        Truck truck = new Truck(2, Color.green, 150, "A cool truck");
        assertEquals(2, truck.getNrDoors());
        truck.setColor(Color.white);
        assertEquals(Color.white, truck.getColor());
        assertEquals(150, truck.getEnginePower());
        assertEquals("A cool truck", truck.getModelName());
        assertEquals(0, truck.getCurrentSpeed());
        assertEquals( new Point2D.Double(), truck.getPosition());
    }

}