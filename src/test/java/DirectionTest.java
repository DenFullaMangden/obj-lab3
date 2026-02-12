import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Test
    void moveTest() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        for (int i = 0; i < 1000; i++) {
            saab.gas(1.0);
        }
        assertEquals(saab.getEnginePower(), saab.getCurrentSpeed());

        saab.turnRight();
        saab.move();
        assertEquals(saab.getEnginePower(), saab.getPosition().getX());
        assertEquals("East", saab.getDirection().toString());

        saab.turnLeft();
        saab.move();
        assertEquals(saab.getEnginePower(), saab.getPosition().getY());
        assertEquals("North", saab.getDirection().toString());

        saab.turnLeft();
        saab.move();
        assertEquals(0.0, saab.getPosition().getX());
        assertEquals("West", saab.getDirection().toString());

        saab.turnLeft();
        saab.move();
        assertEquals(0.0, saab.getPosition().getY());
        assertEquals("South", saab.getDirection().toString());

        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals("South", saab.getDirection().toString());
    }

}
