import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolvoTest {

    @Test
    void volvoTest() {
        Volvo240 volvo = new Volvo240();
        assertEquals(100, volvo.getEnginePower());
        assertEquals(100 * 0.01 * 1.25, volvo.speedFactor());
    }

}
