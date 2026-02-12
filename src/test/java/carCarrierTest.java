import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarCarrierTest {

    @Test
    void loadTest() {
        CarCarrier carCarrier = new CarCarrier(3);
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> carCarrier.load(saab1)
        );

        IllegalStateException exception2 = assertThrows(
                IllegalStateException.class,
                () -> carCarrier.unload()
        );

        carCarrier.switchRamp();
        carCarrier.load(volvo1);
        carCarrier.load(volvo2);
        carCarrier.load(saab1);
        IllegalStateException exception3 = assertThrows(
                IllegalStateException.class,
                () -> carCarrier.load(saab2)
        );

        carCarrier.unload();
        System.out.println(volvo1.isBeingTransported());
        System.out.println(saab1.isBeingTransported());
        IllegalStateException exception4 = assertThrows(
                IllegalStateException.class,
                () -> carCarrier.load(volvo1)
        );

    }
}