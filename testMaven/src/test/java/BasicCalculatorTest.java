import org.junit.*;

import static org.junit.Assert.*;

public class BasicCalculatorTest {
    static BasicCalculator kalkulator;

    @BeforeClass
    public static void myTestSetUp()
    {
        kalkulator = new BasicCalculator();
    }

    @Before
    public void start() {

        System.out.println("Start");

    }


    @After
    public void test(){
        System.out.println("Stop");
    }

    @AfterClass
    public static void end(){
        System.out.println("Wsyzstkie testy pomyslnie");
    }
    @Test
    public void calculateSum1() {
        double t1 = kalkulator.calculateSum(4, 2);
        assertEquals(6, t1, 0);

    }
    @Test
    public void calculateSum2() {
        double t1 = kalkulator.calculateSum(0, 0);
        assertEquals(0, t1, 0);

    }
    @Test
    public void calculateSum3() {
        double t1 = kalkulator.calculateSum(0, 1);
        assertEquals(1, t1, 0);

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


    @Test
    public void calculateMultiplication1() {
        double t1 = kalkulator.calculateMultiplication(8, 2);
        assertEquals(16, t1, 0);

    }

    @Test
    public void calculateMultiplication2() {
        double t1 = kalkulator.calculateMultiplication(0, 4);
        assertEquals(0, t1, 0);
    }
    @Test
    public void calculateMultiplication3() {
        double t1 = kalkulator.calculateMultiplication(0, 0);
        assertEquals(0, t1, 0);
    }

    @Test
    public void calculateDivision1() {
        double t1 = kalkulator.calculateDivision(8, 2);
        assertEquals(4, t1, 0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateDivision2() {
        double t1 = kalkulator.calculateDivision(4, 0);
        assertEquals(2, t1, 0);
    }
    @Test
    public void calculateDivision3() {
        double t1 = kalkulator.calculateDivision(10, 5);
        assertEquals(2, t1, 0);
    }

    @Test
    public void calculatePow1() {
        double t1 = kalkulator.calculatePow(2, 0);
        assertEquals(1, t1, 0);

    }
    @Test
    public void calculatePow2() {
        double t1 = kalkulator.calculatePow(2, 2);
        assertEquals(4, t1, 0);
    }
    @Test
    public void calculatePow3() {
        double t1 = kalkulator.calculatePow(0, 1);
        assertEquals(0, t1, 0);
    }

    @Test
    public void calculateSqrt1() {
        double t1 = kalkulator.calculateSqrt(16);
        assertEquals(4, t1, 0);

    }
    @Test
    public void calculateSqrt2() {
        double t1 = kalkulator.calculateSqrt(1);
        assertEquals(1, t1, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateSqrt3() {
        double t1 = kalkulator.calculateSqrt(-2);
        assertEquals(1, t1, 0);
    }


}