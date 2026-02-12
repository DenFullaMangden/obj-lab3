import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FerryTest {

    @Test
    void transporterTest() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        CarCarrier carCarrier = new CarCarrier(6);
        Ferry ferry = new Ferry(20);

        carCarrier.switchRamp();
        carCarrier.load(volvo);
        ferry.switchRamp();
        ferry.load(carCarrier);
        ferry.load(saab);

        IllegalStateException exception1 = assertThrows(
                IllegalStateException.class,
                () -> ferry.startEngine()
        );

        ferry.switchRamp();
        ferry.startEngine();
        ferry.gas(1);
        ferry.move();
        assertEquals(volvo.getPosition(), ferry.getPosition());

        IllegalStateException exception2 = assertThrows(
                IllegalStateException.class,
                () -> ferry.load(saab)
        );
    }

}