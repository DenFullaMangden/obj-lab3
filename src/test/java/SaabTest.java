import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaabTest
{
    @Test
    void saabTest() {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        assertEquals(125 * 0.01, saab.speedFactor());
        saab.setTurboOn();
        assertEquals(125 * 0.01 * 1.3, saab.speedFactor());
    }
}