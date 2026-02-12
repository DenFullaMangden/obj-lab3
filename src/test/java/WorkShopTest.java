import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkShopTest {

    @Test
    void specificTest() {
        WorkShop<Car> carWorkShop = new WorkShop<Car>(2);
        WorkShop<Truck> truckWorkShop = new WorkShop<Truck>(2);
        WorkShop<Saab95> saabWorkShop = new WorkShop<Saab95>(2);
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Saab95 saab3 = new Saab95();
        Car volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();
        Scania scania1 = new Scania();
        Scania scania2 = new Scania();
        Scania scania3 = new Scania();

        carWorkShop.load(saab1);
        carWorkShop.load(saab2);
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> carWorkShop.load(saab3)
        );

        ClassCastException exception2 = assertThrows(
                ClassCastException.class,
                () -> saabWorkShop.load((Saab95) volvo1)
        );

    }
}