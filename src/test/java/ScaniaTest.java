import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void rampTest() {
        Scania scania = new Scania();
        scania.setLoadAngle(50);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> scania.startEngine()
        );

        IllegalStateException exception2 = assertThrows(
                IllegalStateException.class,
                () -> scania.gas(1)
        );

        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class,
                () -> scania.setLoadAngle(100)
        );

        scania.setLoadAngle(0);
        scania.startEngine();

        IllegalStateException exception4 = assertThrows(
                IllegalStateException.class,
                () -> scania.setLoadAngle(30)
        );


    }


}