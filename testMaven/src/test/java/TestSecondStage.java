
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TestSecondStage {


    static BasicCalculator kalkulator;

    @BeforeClass
    public static void myTestSetUp() {
        kalkulator = new BasicCalculator();
    }
    @Test
    public void calculateDifference1() {
        double t1 = kalkulator.calculateDifference(4, 2);
        assertEquals(2, t1, 0);

    }
    @Test
    public void calculateDifference2() {
        double t1 = kalkulator.calculateDifference(0, -50);
        assertEquals(50, t1, 0);
    }
    @Test
    public void calculateDifference3() {
        double t1 = kalkulator.calculateDifference(0, 0);
        assertEquals(0, t1, 0);
    }
}
